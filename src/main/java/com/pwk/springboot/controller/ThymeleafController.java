package com.pwk.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("name","kelvin");
        return "index";
    }
}
