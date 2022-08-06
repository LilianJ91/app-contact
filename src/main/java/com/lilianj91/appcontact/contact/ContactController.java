package com.lilianj91.appcontact.contact;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
class ContactController {

    private final ContactService contactService;

    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{email}")
    Contact getContact(@PathVariable String email) {
        return contactService.getContact(email);
    }

    @PostMapping("/{email}")
    void upsertContact(@PathVariable String email, @RequestBody Contact contact) {
        contactService.upsertContact(contact);
    }

    @DeleteMapping("/{email}")
    void deleteContact(@PathVariable String email) {
        contactService.deleteContact(email);
    }
}