package com.lilianj91.appcontact.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessErrorHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    public static IllegalArgumentException generateUnknownContactValidationError(String email) {
        return new IllegalArgumentException("The specified contact: '%s' does not exist".formatted(email));
    }

    public static IllegalArgumentException generateUnknownSkillValidationError(String email, String skillName) {
        return new IllegalArgumentException(
                "The specified contact: '%s' does not have the skill: '%s'"
                        .formatted(email, skillName));
    }
}