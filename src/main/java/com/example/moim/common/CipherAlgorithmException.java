package com.example.moim.common;

import org.springframework.http.HttpStatus;

public class CipherAlgorithmException extends MoimException{
    public CipherAlgorithmException(ErrorMessage message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
