package com.lilianj91.appcontact.skill;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;

record Skill(
        @Schema(
                description = "Identifier of the skill.",
                example = "climbing", required = true)
        @NotBlank
        String name,

        @Schema(
                description = "Level of the contact in the skill.",
                example = "COMPETENT", required = true)
        Level level) { }
