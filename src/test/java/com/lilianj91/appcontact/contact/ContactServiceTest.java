package com.lilianj91.appcontact.contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;

    @Mock
    private ContactRepository contactRepository;

    @Test
    void getContact() {
        // Given
        String email = "email";

        Contact contact = new ContactFixture().getContact();
        when(contactRepository.findContactByEmail(email)).thenReturn(Optional.of(contact));

        // When / Then
        assertThat(contactService.getContact(email)).isEqualTo(contact);
    }

    @Test
    void getContact_should_throw_when_contact_does_not_exist() {
        // Given
        String email = "email";

        when(contactRepository.findContactByEmail(email)).thenReturn(Optional.empty());

        // When / Then
        assertThatThrownBy(() -> contactService.getContact(email)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void upsertContact() {
        // Given
        String email = "email";
        Contact contact = new ContactFixture().getContact();

        // When
        contactService.upsertContact(email, contact);

        // Then
        verify(contactRepository).upsertContact(eq(email), eq(contact));
    }

    @Test
    void deleteContact() {
        // Given
        String email = "email";

        when(contactRepository.deleteContact(email)).thenReturn(1);

        // When / Then
        assertDoesNotThrow(() -> contactService.deleteContact(email));
    }

    @Test
    void deleteContact_should_throw_when_contact_does_not_exist() {
        // Given
        String email = "email";

        when(contactRepository.deleteContact(email)).thenReturn(0);

        // When / Then
        assertThatThrownBy(() -> contactService.deleteContact(email)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void doesContactExist(boolean exist) {
        // Given
        String email = "email";

        when(contactRepository.doesContactExist(email)).thenReturn(exist);

        // When / Then
        assertThat(contactService.doesContactExist(email)).isEqualTo(exist);
    }
}