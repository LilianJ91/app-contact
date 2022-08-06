package com.lilianj91.appcontact.contact;

import com.lilianj91.appcontact.generated.jooq.tables.records.ContactRecord;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Component;

@Component
class ContactMapper implements RecordMapper<ContactRecord, Contact> {

    @Override
    public Contact map(ContactRecord contactRecord) {
        return new Contact(
                contactRecord.getFirstName(),
                contactRecord.getLastName(),
                contactRecord.getFullName(),
                contactRecord.getBirthDate() != null
                        ? contactRecord.getBirthDate().toInstant()
                        : null,
                contactRecord.getAddress(),
                contactRecord.getEmail(),
                contactRecord.getMobilePhoneNumber());
    }
}