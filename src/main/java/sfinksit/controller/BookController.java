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
import sfinksit.domain.Book;
import sfinksit.domain.Reference;
import sfinksit.repository.ReferenceRepository;

@Controller
@RequestMapping("/references/createBook")
public class BookController {

    @Autowired
    private ReferenceRepository rep;

    @RequestMapping(method = RequestMethod.GET)
    public String viewCreatePage(@ModelAttribute Reference reference, @ModelAttribute Book book) {
        return "createBook";
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value = "reference") Reference reference, BindingResult bindReference, @Valid @ModelAttribute(value = "book") Book book, BindingResult bindBook, RedirectAttributes redirect, Model model) {
        if (bindReference.hasErrors() || bindBook.hasErrors()) {
            return "createBook";
        }

        if (reference.bibtexKey.isEmpty()) {
            reference.generateBibtexKey(rep);
        }

        // Check that the BibTeX key for the reference is unique
        if (rep.findExistingBibtexKey(reference.bibtexKey).size() > 0) {
            model.addAttribute("notvalidBibtexkey", "BibtexKey has to be unique");
            return "createBook";
        }

        reference.setBook(book);
        rep.save(reference);

        redirect.addFlashAttribute("created", "Book was created");

        return "redirect:/";
    }
}
