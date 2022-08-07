package com.lilianj91.appcontact.contact;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

record Contact(
        @Schema(
                description = "First name of the contact.",
                example = "John", required = true)
        @NotBlank String firstName,

        @Schema(
                description = "Last name of the contact.",
                example = "Doe", required = true)
        @NotBlank String lastName,

        @Schema(
                description = "Full name of the contact.",
                example = "John Doe", required = true)
        @NotBlank String fullName,

        @Schema(
                description = "Birth date of the contact.",
                example = "1996-06-25T00:00.00Z", required = true)
        @Past Instant birthDate,

        @Schema(
                description = "Address of the contact.",
                example = "Rue des Bains 35, 1205 Genève, Suisse", required = true)
        @NotBlank String address,

        @Schema(
                description = "Mobile phone number of the contact.",
                example = "0123456789", required = true)
        @NotBlank @Pattern(regexp = "^[0-9]{10}") String mobilePhoneNumber) {
}
