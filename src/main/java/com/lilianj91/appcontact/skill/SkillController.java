package com.lilianj91.appcontact.skill;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts/{email}/skills")
@Tag(name = "skill", description = "Manage Contact's Skills")
@Validated
class SkillController {

    private final SkillService skillService;

    SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @Operation(
            summary = "Get the skills of a contact",
            description = "This operation will fail if the contact does not exists")
    @GetMapping
    List<Skill> getSkills(@Email @PathVariable String email) {
        return skillService.getSkills(email);
    }

    @Operation(
            summary = "Add or update the skills of a contact",
            description = "This operation will fail if the contact does not exists")
    @PostMapping
    void upsertSkills(@Email @PathVariable String email, @Valid @RequestBody List<Skill> skills) {
        skillService.upsertSkills(email, skills);
    }

    @Operation(
            summary = "Delete a contact's skill",
            description = "This operation will fail if the contact or its specified skill does not exists")
    @DeleteMapping("/{skill-name}")
    void deleteSkill(@Email @PathVariable String email, @PathVariable("skill-name") String skillName) {
        skillService.deleteSkill(email, skillName);
    }
}