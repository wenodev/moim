package com.example.moim.common;

import org.springframework.http.HttpStatus;

public class MoimException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public MoimException(HttpStatus status, ErrorMessage message) {
        this.status = status;
        this.message = message.getMessage();
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
