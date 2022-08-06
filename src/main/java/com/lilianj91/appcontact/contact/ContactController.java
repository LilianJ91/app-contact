package com.lilianj91.appcontact.contact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
class ContactController {

	@GetMapping("/")
	Contact getContact() {
		return new Contact(
				"firstName",
				"lastName",
				"fullName",
				"address",
				"email",
				"mobilePhoneNumber");
	}
}