package com.lilianj91.appcontact.skill;

import javax.validation.constraints.NotBlank;

record Skill(@NotBlank String name, Level level) { }
