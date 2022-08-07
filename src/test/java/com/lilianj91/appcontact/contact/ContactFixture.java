package com.lilianj91.appcontact.contact;

import java.time.Instant;

public class ContactFixture {
    private String firstName;
    private String lastName;
    private String fullName;
    private Instant birthDate;
    private String address;
    private String mobilePhoneNumber;

    ContactFixture() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.fullName = "fullName";
        this.birthDate = Instant.now();
        this.address = "address";
        this.mobilePhoneNumber = "mobilePhoneNumber";
    }

    Contact getContact() {
        return new Contact(
                firstName,
                lastName,
                fullName,
                birthDate,
                address,
                mobilePhoneNumber
        );
    }
}