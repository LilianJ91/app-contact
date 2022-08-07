package com.lilianj91.appcontact.skill;

public class SkillFixture {
    private String name;
    private Level level;

    SkillFixture() {
        this.name = "name";
        this.level = Level.COMPETENT;
    }

    Skill getSkill() {
        return new Skill(name, level);
    }
}