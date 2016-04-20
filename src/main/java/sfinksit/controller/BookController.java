package sfinksit.controller;

import java.util.List;
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
import sfinksit.domain.Book;
import sfinksit.domain.Reference;
import sfinksit.repository.BookRepository;
import sfinksit.repository.ReferenceRepository;

@Controller
@RequestMapping("/references/createBook")
public class BookController {
    
    @Autowired
    private ReferenceRepository rep;
    
    @Autowired
    private BookRepository bookrep;
    
    @RequestMapping(method=RequestMethod.GET)
    public String viewCreatePage(@ModelAttribute Reference reference) {
        return "createBook";
    }
    
    @Transactional
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute Reference reference, BindingResult bind, RedirectAttributes redirect, Model model) {
        if (bind.hasErrors()) {
            return "createBook";
        }
        List list = rep.findExistingBibtexKey(reference.bibtexKey);
        if (list.size() > 0){
            model.addAttribute("notvalidBibtexkey", "BibtexKey has to be unique");
            return "createBook";
        }
        
        rep.save(reference);
        
        redirect.addFlashAttribute("created", "Book was created");
        
        return "redirect:/";
    }
}
