package com.lilianj91.appcontact.contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
@Tag(name = "contact", description = "Manage Contacts")
@Validated
class ContactController {

    private final ContactService contactService;

    ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @Operation(
            summary = "Get Contact by email",
            description = "This operation will fail if the contact does not exists")
    @GetMapping("/{email}")
    Contact getContact(@Email @PathVariable String email) {
        return contactService.getContact(email);
    }

    @Operation(summary = "Create or update Contact by email", description = "This operation is idempotent")
    @PutMapping("/{email}")
    void upsertContact(@Email @PathVariable String email, @Valid @RequestBody Contact contact) {
        contactService.upsertContact(email, contact);
    }

    @Operation(
            summary = "Delete a Contact by email",
            description = "This operation will fail if the contact does not exists")
    @DeleteMapping("/{email}")
    void deleteContact(@Email @PathVariable String email) {
        contactService.deleteContact(email);
    }
}