package com.lilianj91.appcontact.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
class ContactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/")
    Contact getContact() {

        LOGGER.info("Contact recovered");

        return new Contact(
                "firstName",
                "lastName",
                "fullName",
                "address",
                "email",
                "mobilePhoneNumber");
    }
}