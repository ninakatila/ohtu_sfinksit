package sfinksit.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;
import sfinksit.tools.SearchCheck;

@Controller
@RequestMapping("*")
public class ReferenceController {

    @Autowired
    private ReferenceRepository rep;

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "index";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("references", rep.findAll());
        return "list";
    }
    
    @RequestMapping(value="bibtex", method=RequestMethod.GET)
    public String viewBibtex(Model model) {
        model.addAttribute("references", rep.findAll());
        return "bibtex";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String viewfindThisObject(String name, @ModelAttribute Reference reference) {
        return "findObject";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String findThisObject(@RequestParam(value = "search") String searchTerm, Model model) {
        SearchCheck check = new SearchCheck(searchTerm);
        if (!check.checkWordValidation()) {
            model.addAttribute("failedSearch", "Hakuehto ei täytä vaatimuksia");
            return "findObject";
        }
        
        if (check.wordContainsOnlyInteger()) {
            int searchInt = Integer.parseInt(searchTerm);
            model.addAttribute("references", rep.findSearchTermFromStringsAndIntegers(searchTerm, searchInt));
        } else {
            model.addAttribute("references", rep.findSearchTermFromAll(searchTerm));
        }
        
        return "bibtex";
    }
    
    @RequestMapping(value="/references/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        rep.delete(id);
        
        return "redirect:/list";
    }
}
