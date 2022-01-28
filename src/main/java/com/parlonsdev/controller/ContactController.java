package com.parlonsdev.controller;

import com.parlonsdev.dto.ContactDto;
import com.parlonsdev.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(path = "/save-contact")
    public String saveContact(@ModelAttribute("contact") @Valid ContactDto contactDto,
                              BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return "contact";
        contactService.saveContact(contactDto);
        return "redirect:/contact?success";
    }
}
