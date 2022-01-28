package com.parlonsdev.controller;

import com.parlonsdev.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String login(Model model, @ModelAttribute("user")User user){
        model.addAttribute("user", user);
        return "login";
    }
}
