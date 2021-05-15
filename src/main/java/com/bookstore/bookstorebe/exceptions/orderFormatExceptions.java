package com.bookstore.bookstorebe.exceptions;

import org.springframework.http.HttpStatus;

public class orderFormatExceptions extends RuntimeException{
    public orderFormatExceptions(String errorMessage) {
        super(errorMessage);
    }
}
