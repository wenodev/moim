package com.example.moim.common;

import org.springframework.http.HttpStatus;

public class NotMatchException extends MoimException {
    public NotMatchException(ErrorMessage message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
