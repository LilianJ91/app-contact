package com.lilianj91.appcontact.skill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lilianj91.appcontact.common.JsonbMapper;
import com.lilianj91.appcontact.generated.jooq.tables.records.ContactSkillRecord;
import com.lilianj91.appcontact.generated.jooq.tables.records.SkillRecord;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class SkillMapper implements RecordMapper<Record, Skill> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillMapper.class);

    private final JsonbMapper jsonbMapper;

    SkillMapper(JsonbMapper jsonbMapper) {
        this.jsonbMapper = jsonbMapper;
    }

    @Override
    public Skill map(Record record) {

        ContactSkillRecord contactSkillRecord = record.into(ContactSkillRecord.class);
        SkillRecord skillRecord = record.into(SkillRecord.class);

        try {
            return new Skill(
                    skillRecord.getName(),
                    jsonbMapper.map(contactSkillRecord.getLevel(), Level.class));
        } catch (JsonProcessingException exception) {
            LOGGER.warn("Fail to deserialise level: {}", contactSkillRecord.getLevel(), exception);
            throw new RuntimeException("Unexcepted mapping error");
        }
    }
}