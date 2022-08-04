package com.example.moim.common;

public enum ErrorMessage {
    PASSWORD_NOT_MATCH("비밀번호가 일치하지 않습니다."),
    CIPHER_ALGORITHM_NOT_FOUND("존재하지 않는 알고리즘 입니다."),
    MEMBER_NOT_FOUND("존재하지 않는 유저입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
