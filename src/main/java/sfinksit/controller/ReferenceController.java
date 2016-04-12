package sfinksit.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

@Controller
@RequestMapping("/references")
public class ReferenceController {
    
    @Autowired
    private ReferenceRepository rep;

    @RequestMapping(method=RequestMethod.GET)
    public String view() {
        return "index";
    }
    
    @Transactional
    @RequestMapping(method=RequestMethod.POST)// 
    public String create(@Valid @ModelAttribute Reference ref, BindingResult bind) {
        
        if (bind.hasErrors()) {
            return "index";
        }
        return "redirect:/create";
    }
    
}
