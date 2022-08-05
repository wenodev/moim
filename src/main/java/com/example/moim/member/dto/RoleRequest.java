package com.example.moim.member.dto;

public class RoleRequest {
    private String role;

    public RoleRequest(String role) {
        this.role = role;
    }

    public RoleRequest() {
    }

    public String getRole() {
        return role;
    }
}
