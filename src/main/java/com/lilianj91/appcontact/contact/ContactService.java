package com.lilianj91.appcontact.contact;

import com.lilianj91.appcontact.common.BusinessErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactService.class);

    private final ContactRepository contactRepository;

    ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional(readOnly = true)
    public Contact getContact(String email) {
        return contactRepository.findContactByEmail(email).orElseThrow(
                () -> {
                    LOGGER.warn("Can't find contact by email: {}", email);
                    return BusinessErrorHandler.generateUnknownContactValidationError(email);
                }
        );
    }

    @Transactional
    public void upsertContact(Contact contact) {
        contactRepository.upsertContact(contact);
    }

    @Transactional
    public void deleteContact(String email) {
        if (contactRepository.deleteContact(email) == 0) {
            LOGGER.warn("Can't delete contact by email: {}", email);
            throw BusinessErrorHandler.generateUnknownContactValidationError(email);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public boolean doesContactExist(String email) {
        return contactRepository.doesContactExist(email);
    }
}