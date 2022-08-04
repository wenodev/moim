package com.example.moim.auth.dto;

public class TokenResponse {
    private String accessToken;

    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public TokenResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }
}
