package com.example.moim.member.dto;

import com.example.moim.member.domain.Gender;
import com.example.moim.member.domain.Member;

import java.time.LocalDate;

public class HostResponse {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String userID;
    private String email;
    private String company;

    public static HostResponse of(Member member) {
        return new HostResponse(member.getId(), member.getName(), member.getDateOfBirth(),
                member.getGender(), member.getUserID(), member.getEmail(), member.getCompany());
    }

    public HostResponse() {
    }

    public HostResponse(Long id, String name, LocalDate dateOfBirth, Gender gender,
                        String userID, String email, String company) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userID = userID;
        this.email = email;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }
}
