package com.lilianj91.appcontact.contact;

import java.time.Instant;

public class ContactFixture
{
    private String firstName;
    private String lastName;
    private String fullName;
    private Instant birthDate;
    private String address;
    private String email;
    private String mobilePhoneNumber;

    ContactFixture(String email) {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.fullName = "fullName";
        this.birthDate = Instant.now();
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    Contact getContact() {
        return new Contact(
                firstName,
                lastName,
                fullName,
                 birthDate,
                address,
                email,
                mobilePhoneNumber
        );
    }
}