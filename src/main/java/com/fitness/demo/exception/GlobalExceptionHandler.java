package com.fitness.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class provides a centralized place to handle all the exceptions, instead of scatter these logics in the code. This ensures we have standard message format to send to frontend for different types of exception
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e) {
        StringBuilder errMsg = new StringBuilder();
        for (FieldError err:e.getErrors().getFieldErrors()) {
            errMsg.append(err.getField()).append(": ").append(err.getDefaultMessage()).append("\n");
        }
        return new ResponseEntity<String>(errMsg.toString(), HttpStatus.BAD_REQUEST);
    }


}
