package com.parlonsdev.service;

import com.parlonsdev.dto.ContactDto;
import com.parlonsdev.model.Contact;
import com.parlonsdev.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(@Valid ContactDto contactDto){

        Contact contact = new Contact(contactDto.getFirstName(), contactDto.getLastName(),
                                                    contactDto.getEmail(), contactDto.getMessage());
        return contactRepository.save(contact);

    }
}
