package com.lilianj91.appcontact.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.lilianj91.appcontact.generated.jooq.tables.records.ContactRecord;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContactMapperTest {

    @InjectMocks
    private ContactMapper contactMapper;

    @Test
    void map() {
        // Given
        String firstName = "firstName";
        String lastName = "lastName";
        String fullName = "fullName";

        Instant now = Instant.now();
        OffsetDateTime birthDate = OffsetDateTime.ofInstant(now, ZoneOffset.UTC);

        String address = "address";
        String email = "email";
        String mobilePhoneNumber = "mobilePhoneNumber";

        ContactRecord contactRecord = new ContactRecord(
                firstName,
                lastName,
                fullName,
                birthDate,
                address,
                email,
                mobilePhoneNumber);

        // When
        Contact contact = contactMapper.map(contactRecord);

        // Then
        Assertions.assertAll(
                () -> assertEquals(firstName, contact.firstName()),
                () -> assertEquals(lastName, contact.lastName()),
                () -> assertEquals(fullName, contact.fullName()),
                () -> assertEquals(now, contact.birthDate()),
                () -> assertEquals(address, contact.address()),
                () -> assertEquals(mobilePhoneNumber, contact.mobilePhoneNumber())
        );
    }
}