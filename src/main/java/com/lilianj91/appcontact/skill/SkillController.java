package com.lilianj91.appcontact.skill;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("contacts/{email}/skills")
@Validated
class SkillController {

    private final SkillService skillService;

    SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    List<Skill> getSkills(@Email @PathVariable String email) {
        return skillService.getSkills(email);
    }

    @PostMapping
    void upsertSkills(@Email @PathVariable String email, @Valid @RequestBody List<Skill> skills) {
        skillService.upsertSkills(email, skills);
    }

    @DeleteMapping("/{skill-name}")
    void deleteSkill(@Email @PathVariable String email, @PathVariable("skill-name") String skillName) {
        skillService.deleteSkill(email, skillName);
    }
}