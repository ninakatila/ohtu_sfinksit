package sfinksit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sfinksit.repository.ArticleRepository;
import sfinksit.repository.ReferenceRepository;

@Controller
public class ArticleController {
    @Autowired
    private ReferenceRepository rep;
    private ArticleRepository articlerep;
    
}
