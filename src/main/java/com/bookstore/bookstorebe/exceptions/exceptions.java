package com.bookstore.bookstorebe.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class exceptions {

    @ExceptionHandler(orderFormatExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleUserNotFoundException(orderFormatExceptions ex) {
        return new ResponseEntity<String>("nopeee", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity nope(InvalidFormatException ex) {
        return new ResponseEntity<String>("not gonna work bruhh", HttpStatus.BAD_REQUEST);
    }
}
