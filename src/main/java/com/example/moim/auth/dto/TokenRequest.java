package com.example.moim.auth.dto;

public class TokenRequest {
    private String userId;
    private String password;

    public TokenRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public TokenRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
