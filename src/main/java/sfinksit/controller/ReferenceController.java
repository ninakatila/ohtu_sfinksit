package sfinksit.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

@Controller
@RequestMapping("*")
public class ReferenceController {
    
    @Autowired
    private ReferenceRepository rep;

    @RequestMapping(value="/references", method=RequestMethod.GET)
    public String view(@ModelAttribute Reference ref) {
        return "create";
    }
    
    @Transactional
    @RequestMapping(method=RequestMethod.POST)// 
    public String create(@Valid @ModelAttribute Reference ref, BindingResult bind) {
        
        if (bind.hasErrors()) {
            return "redirect:/references";
        }
        rep.save(ref);
        return "redirect:/";
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("references", rep.findAll());
        return "list";
    }
    
    @RequestMapping(value="search", method=RequestMethod.GET)
    public String viewfindThisObject(String name, @ModelAttribute Reference reference){
        return "findObject";
    }
    
    @RequestMapping(value="search", method=RequestMethod.POST)
    public String findThisObject(@RequestParam(value = "search") String searchTerm, Model model){
        if (!validateStringSearch(searchTerm)){
            model.addAttribute("failedSearch", "Hakuehto liian pitkä");
            return "findObject";
        }

        model.addAttribute("references", rep.findSearchTermFromAll(searchTerm));
        return "list";
    }
    
    public boolean validateStringSearch(String searchTerm) {
        if (searchTerm.length() > 20) return false;
        //injektion mahdollisuus, jos suoraan merkkijonosta tehdään query
        return true;
    }
    
}
