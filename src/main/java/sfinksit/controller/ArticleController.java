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
import sfinksit.domain.Article;
import sfinksit.domain.Reference;
import sfinksit.repository.ArticleRepository;
import sfinksit.repository.ReferenceRepository;
import sfinksit.tools.Generator;

@Controller
@RequestMapping("/references/article")
public class ArticleController {

    @Autowired
    private ReferenceRepository rep;
    
    @Autowired
    private ArticleRepository articles;

    @RequestMapping(method = RequestMethod.GET)
    public String viewCreatePage(@ModelAttribute Reference reference) {
        return "article";
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Reference reference, BindingResult bind, RedirectAttributes redirect, Model model) {

        if (bind.hasErrors()) {
            return "article";
        }

        if (reference.bibtexKey.isEmpty()) {

            Generator gen = new Generator();
            reference.bibtexKey = gen.generate(rep, reference);

        }

        List list = rep.findExistingBibtexKey(reference.bibtexKey);
        if (list.size() > 0) {
            model.addAttribute("notvalidBibtexkey", "BibtexKey has to be unique");
            return "article";
        }

        rep.save(reference);

        redirect.addFlashAttribute("created", "Reference has created");

        return "redirect:/";
    }

}
