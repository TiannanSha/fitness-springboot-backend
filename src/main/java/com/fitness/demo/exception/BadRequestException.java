package com.fitness.demo.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class BadRequestException extends RuntimeException{
    Errors errors;

    public BadRequestException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
