package com.example.mvc_architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user")
    public String user(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "Hello, " + name + "! Welcome to the User Page!");
        return "home";
    }
}
