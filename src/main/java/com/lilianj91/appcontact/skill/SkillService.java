package com.lilianj91.appcontact.skill;

import com.lilianj91.appcontact.common.BusinessErrorHandler;
import com.lilianj91.appcontact.contact.ContactService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class SkillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);

    private final ContactService contactService;
    private final SkillRepository skillRepository;

    SkillService(ContactService contactService, SkillRepository skillRepository) {
        this.contactService = contactService;
        this.skillRepository = skillRepository;
    }

    @Transactional(readOnly = true)
    public List<Skill> getSkills(String email) {
        if (!contactService.doesContactExist(email)) {
            LOGGER.warn("Can't find skills by email: {}", email);
            throw BusinessErrorHandler.generateUnknownContactValidationError(email);
        }
        return skillRepository.findSkillsByEmail(email);
    }

    @Transactional
    public void upsertSkills(String email, List<Skill> skills) {
        if (!contactService.doesContactExist(email)) {
            LOGGER.warn("Can't upsert skills by email: {}", email);
            throw BusinessErrorHandler.generateUnknownContactValidationError(email);
        }
        skillRepository.upsertSkills(email, skills);
    }

    @Transactional
    public void deleteSkill(String email, String skillName) {
        if (!contactService.doesContactExist(email)) {
            LOGGER.warn("Can't delete skill by email: {}", email);
            throw BusinessErrorHandler.generateUnknownContactValidationError(email);
        }
        if (skillRepository.deleteSkill(email, skillName) == 0) {
            LOGGER.warn("Can't delete skill by email: {}", email);
            throw BusinessErrorHandler.generateUnknownSkillValidationError(email, skillName);
        }
    }
}