package com.lilianj91.appcontact.contact;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("contacts")
@Validated
class ContactController {

    private final ContactService contactService;

    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{email}")
    Contact getContact(@Email @PathVariable String email) {
        return contactService.getContact(email);
    }

    @PostMapping("/{email}")
    void upsertContact(@Email @PathVariable String email, @Valid @RequestBody Contact contact) {
        contactService.upsertContact(email, contact);
    }

    @DeleteMapping("/{email}")
    void deleteContact(@Email @PathVariable String email) {
        contactService.deleteContact(email);
    }
}