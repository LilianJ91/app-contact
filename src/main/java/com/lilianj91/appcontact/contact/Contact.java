package com.lilianj91.appcontact.contact;

import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

record Contact(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String fullName,
        @Past Instant birthDate,
        @NotBlank String address,
        @NotBlank @Pattern(regexp = "^[0-9]{10}") String mobilePhoneNumber) {
}
