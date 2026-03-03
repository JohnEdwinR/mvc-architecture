package com.example.mvc_architecture.controller;

import com.example.mvc_architecture.model.User;
import com.example.mvc_architecture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "home";
    }

    @GetMapping("/user")
    public String user(@RequestParam("name") String name, Model model) {
        // Create and save user to database
        User user = new User(name);
        userRepository.save(user);
        
        model.addAttribute("message", "Hello, " + name + "! Your name has been saved to the database.");
        return "home";
    }
}
