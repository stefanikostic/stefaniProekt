package com.example.stefaniProekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidStockException extends RuntimeException {

    public InvalidStockException() {
        super(InvalidStockException.class.getSimpleName());
    }
}