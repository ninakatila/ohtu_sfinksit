package sfinksit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sfinksit.repository.BookRepository;
import sfinksit.repository.ReferenceRepository;

@Controller
@RequestMapping("*")
public class BookController {
    
    @Autowired
    private ReferenceRepository rep;
    private BookRepository bookrep;
    
}
