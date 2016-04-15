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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sfinksit.repository.ArticleRepository;
import sfinksit.repository.ReferenceRepository;
import sfinksit.domain.Article;
import sfinksit.domain.Reference;

@Controller
@RequestMapping("/references/article")
public class ArticleController {

    @Autowired
    private ReferenceRepository rep;

    @Autowired
    private ArticleRepository articlerep;
    
    @RequestMapping(method=RequestMethod.GET)
    public String viewCreatePage(@ModelAttribute Reference reference) {
        return "article";
    }
    
    @Transactional
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute Reference reference, BindingResult bind, RedirectAttributes redirect) {
        if (bind.hasErrors()) {
            return "article";
        }
        
        rep.save(reference);
        
        redirect.addFlashAttribute("created", "Reference has created");
        
        return "redirect:/";
    }
    
}
