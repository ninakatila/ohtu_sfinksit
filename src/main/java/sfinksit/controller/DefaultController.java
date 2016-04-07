package sfinksit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*")
public class DefaultController {

    public String hello() {
        return "index";
    }
}