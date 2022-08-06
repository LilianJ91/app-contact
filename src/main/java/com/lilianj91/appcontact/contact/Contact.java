package com.lilianj91.appcontact.contact;

import java.time.Instant;

record Contact(
        String firstName,
        String lastName,
        String fullName,
        Instant birthDate,
        String address,
        String email,
        String mobilePhoneNumber) {
}
