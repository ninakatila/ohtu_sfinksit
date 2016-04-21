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
import sfinksit.repository.ArticleRepository;
import sfinksit.repository.ReferenceRepository;
import sfinksit.domain.Article;
import sfinksit.domain.Reference;

@Controller
@RequestMapping("/references/article")
public class ArticleController {

    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};

    @Autowired
    private ReferenceRepository rep;

    @Autowired
    private ArticleRepository articlerep;

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

            String key = reference.bibtexKey = reference.author.substring(0, 1) + reference.year;
            if (rep.findExistingBibtexKey(key).size()>0) {
                for (int i = 0; i < 6; i++) {
                    key = key + alphabet[i];
                    if (rep.findExistingBibtexKey(key).size()>0) {
                        key = key.substring(0, key.length() - 1);
                    } else {
                        break;
                    }

                }
            }
            reference.bibtexKey = key;
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
