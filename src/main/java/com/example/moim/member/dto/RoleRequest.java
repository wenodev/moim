package com.example.moim.member.dto;

import com.example.moim.member.domain.Role;

public class RoleRequest {
    private Role role;

    public RoleRequest(Role role) {
        this.role = role;
    }

    public RoleRequest() {
    }

    public Role getRole() {
        return role;
    }
}
