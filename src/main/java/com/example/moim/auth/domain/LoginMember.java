package com.example.moim.auth.domain;

public class LoginMember {
    public static final String guestMemberId = "guest-id";

    private String memberId;

    public static LoginMember guest() {
        return new LoginMember(guestMemberId);
    }

    public LoginMember() {
    }

    public LoginMember(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }
}
