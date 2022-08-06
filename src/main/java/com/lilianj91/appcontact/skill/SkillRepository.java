package com.lilianj91.appcontact.skill;

import static com.lilianj91.appcontact.generated.jooq.Tables.CONTACT_SKILL;
import static com.lilianj91.appcontact.generated.jooq.Tables.SKILL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lilianj91.appcontact.common.JsonbMapper;
import com.lilianj91.appcontact.generated.jooq.tables.records.ContactSkillRecord;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
class SkillRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillRepository.class);

    private final SkillMapper skillMapper;
    private final JsonbMapper jsonbMapper;
    private final DSLContext dslContext;

    SkillRepository(SkillMapper skillMapper, JsonbMapper jsonbMapper, DSLContext dslContext) {
        this.skillMapper = skillMapper;
        this.jsonbMapper = jsonbMapper;
        this.dslContext = dslContext;
    }

    List<Skill> findSkillsByEmail(String email) {
        return dslContext.select(SKILL.NAME, CONTACT_SKILL.LEVEL)
                .from(CONTACT_SKILL)
                .join(SKILL)
                .on(CONTACT_SKILL.FK_SKILL_NAME.eq(SKILL.NAME))
                .where(CONTACT_SKILL.FK_CONTACT_EMAIL.eq(email))
                .fetch(skillMapper);
    }

    void upsertSkills(String email, List<Skill> skills) {
        dslContext.batch(
                skills.stream()
                        .map(skill -> {
                            try {
                                return upsertSkill(email, skill);
                            } catch (JsonProcessingException exception) {
                                LOGGER.warn("Fail upsert skills", exception);
                                throw new RuntimeException(exception);
                            }
                        })
                        .toList())
                .execute();
    }

    private InsertOnDuplicateSetMoreStep<ContactSkillRecord> upsertSkill(
            String email,
            Skill skill)
            throws JsonProcessingException {

        dslContext.insertInto(SKILL)
                .columns(SKILL.NAME)
                .values(skill.name())
                .onDuplicateKeyIgnore()
                .execute();

        return dslContext.insertInto(CONTACT_SKILL)
                .columns(
                        CONTACT_SKILL.FK_CONTACT_EMAIL,
                        CONTACT_SKILL.FK_SKILL_NAME,
                        CONTACT_SKILL.LEVEL
                ).values(
                        email,
                        skill.name(),
                        jsonbMapper.map(skill.level())
                ).onConflict(CONTACT_SKILL.FK_CONTACT_EMAIL, CONTACT_SKILL.FK_SKILL_NAME)
                .doUpdate()
                .set(CONTACT_SKILL.LEVEL, jsonbMapper.map(skill.level()));
    }

    int deleteSkill(String email, String skillName) {
        return dslContext.deleteFrom(CONTACT_SKILL)
                .where(CONTACT_SKILL.FK_CONTACT_EMAIL.eq(email))
                .and(CONTACT_SKILL.FK_SKILL_NAME.eq(skillName))
                .execute();
    }
}