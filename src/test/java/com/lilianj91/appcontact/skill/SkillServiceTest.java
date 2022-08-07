package com.lilianj91.appcontact.skill;

import com.lilianj91.appcontact.contact.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SkillServiceTest {

    @InjectMocks
    private SkillService skillService;

    @Mock
    private ContactService contactService;

    @Mock
    private SkillRepository skillRepository;

    @Test
    void getSkills() {
        // Given
        String email = "email";

        List<Skill> skills = List.of(new SkillFixture().getSkill());

        when(contactService.doesContactExist(email)).thenReturn(true);
        when(skillRepository.findSkillsByEmail(email)).thenReturn(skills);

        // When / Then
        assertThat(skillService.getSkills(email)).isEqualTo(skills);
    }

    @Test
    void getSkills_should_throw_when_contact_does_not_exist() {
        // Given
        String email = "email";

        when(contactService.doesContactExist(email)).thenReturn(false);

        // When / Then
        assertThatThrownBy(() -> skillService.getSkills(email)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void upsertSkills() {
        // Given
        String email = "email";
        List<Skill> skills = List.of(new SkillFixture().getSkill());

        when(contactService.doesContactExist(email)).thenReturn(true);

        // When
        skillService.upsertSkills(email, skills);

        // Then
        verify(skillRepository).upsertSkills(eq(email), eq(skills));
    }

    @Test
    void upsertSkills_should_throw_when_contact_does_not_exist() {
        // Given
        String email = "email";

        when(contactService.doesContactExist(email)).thenReturn(false);

        // When / Then
        assertThatThrownBy(() -> skillService.upsertSkills(email, List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void deleteSkill() {
        // Given
        String email = "email";
        String skillName = "skillName";

        when(contactService.doesContactExist(email)).thenReturn(true);
        when(skillRepository.deleteSkill(email, skillName)).thenReturn(1);

        // When
        assertDoesNotThrow(() -> skillService.deleteSkill(email, skillName));
    }

    @Test
    void deleteSkill_should_throw_when_contact_does_not_exist() {
        // Given
        String email = "email";
        String skillName = "skillName";

        when(contactService.doesContactExist(email)).thenReturn(false);

        // When
        assertThatThrownBy(() -> skillService.deleteSkill(email, skillName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void deleteSkill_should_throw_when_contact_does_not_have_the_skill() {
        // Given
        String email = "email";
        String skillName = "skillName";

        when(contactService.doesContactExist(email)).thenReturn(true);
        when(skillRepository.deleteSkill(email, skillName)).thenReturn(0);

        // When
        assertThatThrownBy(() -> skillService.deleteSkill(email, skillName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}