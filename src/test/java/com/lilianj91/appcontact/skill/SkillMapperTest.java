package com.lilianj91.appcontact.skill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lilianj91.appcontact.common.JsonbMapper;
import com.lilianj91.appcontact.generated.jooq.tables.records.ContactSkillRecord;
import org.jooq.JSONB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SkillMapperTest {

    @InjectMocks
    private SkillMapper skillMapper;

    @Mock
    private JsonbMapper jsonbMapper;

    @Test
    void apply() throws JsonProcessingException {
        // Given
        String name = "name";
        JSONB serializedLevel = JSONB.jsonb("""
                {"level":"COMPETENT"}""");
        Level level = Level.COMPETENT;

        when(jsonbMapper.map(serializedLevel, Level.class)).thenReturn(level);

        ContactSkillRecord contactSkillRecord = new ContactSkillRecord(
                serializedLevel,
                "email",
                name);

        // When
        Skill skill = skillMapper.apply(contactSkillRecord);

        // Then
        Assertions.assertAll(
                () -> assertEquals(name, skill.name()),
                () -> assertEquals(level, skill.level())
        );
    }
}