package com.example.springbootTutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloContorller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","junwoo");
        return "hello/hello";
    }
}
