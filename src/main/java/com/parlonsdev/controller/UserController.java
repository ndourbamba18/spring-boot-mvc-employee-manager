package com.parlonsdev.controller;

import com.parlonsdev.dto.UserRegistrationDto;
import com.parlonsdev.model.Employee;
import com.parlonsdev.model.User;
import com.parlonsdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    /*@GetMapping
    public String userRegistrationForm(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }*/

    @GetMapping
    public String userRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registrationUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        if (userService.existsByEmail(userRegistrationDto.getEmail())){
            return "registration";
        }
        userService.saveUser(userRegistrationDto);
        //return "redirect:/registration?success";
        return "registration_success";
    }

    @GetMapping(path = "/registration-success")
    public String registrationSuccess(Model model, @ModelAttribute("user") User user){
        model.addAttribute("user", user);
        return "registration_success";
    }
}
