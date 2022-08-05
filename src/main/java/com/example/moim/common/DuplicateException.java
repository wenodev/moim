package com.example.moim.common;

import org.springframework.http.HttpStatus;

public class DuplicateException extends MoimException {
    public DuplicateException(ErrorMessage message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
