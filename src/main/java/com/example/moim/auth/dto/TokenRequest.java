package com.example.moim.auth.dto;

public class TokenRequest {
    private String memberId;
    private String password;

    public TokenRequest(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public TokenRequest() {
    }

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
    }
}
