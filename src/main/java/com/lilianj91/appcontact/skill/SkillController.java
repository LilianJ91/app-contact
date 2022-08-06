package com.lilianj91.appcontact.skill;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts/{email}/skills")
class SkillController {

    private final SkillService skillService;

    SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    List<Skill> getSkills(@PathVariable String email) {
        return skillService.getSkills(email);
    }

    @PostMapping
    void upsertSkills(@PathVariable String email, @RequestBody List<Skill> skills) {
        skillService.upsertSkills(email, skills);
    }

    @DeleteMapping("/{skill-name}")
    void deleteSkill(@PathVariable String email, @PathVariable("skill-name") String skillName) {
        skillService.deleteSkill(email, skillName);
    }
}