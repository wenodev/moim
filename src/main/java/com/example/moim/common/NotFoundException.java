package com.example.moim.common;

import org.springframework.http.HttpStatus;

public class NotFoundException extends MoimException {
    public NotFoundException(ErrorMessage message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
