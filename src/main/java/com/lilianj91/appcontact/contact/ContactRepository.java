package com.lilianj91.appcontact.contact;

import static com.lilianj91.appcontact.generated.jooq.Tables.CONTACT_;

import com.lilianj91.appcontact.generated.jooq.tables.records.ContactRecord;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.stereotype.Service;

@Service
class ContactRepository {

    private final ContactMapper contactMapper;
    private final DSLContext dslContext;

    Field[] contactFields = {
            CONTACT_.FIRST_NAME,
            CONTACT_.LAST_NAME,
            CONTACT_.FULL_NAME,
            CONTACT_.BIRTH_DATE,
            CONTACT_.ADDRESS,
            CONTACT_.EMAIL,
            CONTACT_.MOBILE_PHONE_NUMBER};

    ContactRepository(ContactMapper contactMapper, DSLContext dslContext) {
        this.contactMapper = contactMapper;
        this.dslContext = dslContext;
    }

    Optional<Contact> findContactByEmail(String email) {
        return dslContext.select(contactFields)
                .from(CONTACT_)
                .where(CONTACT_.EMAIL.eq(email))
                .fetchOptionalInto(ContactRecord.class)
                .map(contactMapper::map);
    }

    void upsertContact(String email, Contact contact) {
        dslContext.insertInto(CONTACT_)
                .columns(contactFields)
                .values(
                        contact.firstName(),
                        contact.lastName(),
                        contact.fullName(),
                        toUTCDateTime(contact.birthDate()),
                        contact.address(),
                        email,
                        contact.mobilePhoneNumber()
                ).onConflict(CONTACT_.EMAIL)
                .doUpdate()
                .set(CONTACT_.FIRST_NAME, contact.firstName())
                .set(CONTACT_.LAST_NAME, contact.lastName())
                .set(CONTACT_.FULL_NAME, contact.fullName())
                .set(CONTACT_.BIRTH_DATE, toUTCDateTime(contact.birthDate()))
                .set(CONTACT_.ADDRESS, contact.address())
                .set(CONTACT_.MOBILE_PHONE_NUMBER, contact.mobilePhoneNumber())
                .execute();
    }

    int deleteContact(String email) {
        return dslContext.deleteFrom(CONTACT_)
                .where(CONTACT_.EMAIL.eq(email))
                .execute();
    }

    boolean doesContactExist(String email) {
        return dslContext.fetchExists(
                dslContext.selectOne()
                        .from(CONTACT_)
                        .where(CONTACT_.EMAIL.eq(email)));
    }

    private OffsetDateTime toUTCDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return instant.atOffset(ZoneOffset.UTC);
    }
}