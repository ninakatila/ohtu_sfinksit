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
import sfinksit.domain.Conference;
import sfinksit.domain.Reference;
import sfinksit.repository.ConferenceRepository;
import sfinksit.repository.ReferenceRepository;
import sfinksit.tools.Generator;

@Controller
@RequestMapping("/references/createConference")
public class ConferenceController {
    
    @Autowired
    private ReferenceRepository rep;
    
    
    @RequestMapping(method=RequestMethod.GET)
    public String viewCreatePage(@ModelAttribute Reference reference, @ModelAttribute Conference conference) {
        return "createConference";
    }
    
    @Transactional
    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="reference") Reference reference, BindingResult bindReference, @Valid @ModelAttribute(value="conference") Conference conference, BindingResult bindConference, RedirectAttributes redirect, Model model) {
        if (bindReference.hasErrors() || bindConference.hasErrors()) {
            return "createConference";
        }
         if (reference.bibtexKey.isEmpty()) {

            Generator gen = new Generator();
            reference.bibtexKey = gen.generate(rep, reference);

        }
        List list = rep.findExistingBibtexKey(reference.bibtexKey);
        if (list.size() > 0){
            model.addAttribute("notvalidBibtexkey", "BibtexKey has to be unique");
            return "createConference";
        }
        
        reference.setConference(conference);
        rep.save(reference);
        
        redirect.addFlashAttribute("created", "Reference has created");
        
        return "redirect:/";
    }
}
