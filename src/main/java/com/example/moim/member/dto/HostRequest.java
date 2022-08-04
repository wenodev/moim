package com.example.moim.member.dto;

import com.example.moim.member.domain.Gender;

import java.time.LocalDate;

public class HostRequest {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String userID;
    private String password;
    private String email;
    private String company;

    public HostRequest() {
    }

    public HostRequest(String name, LocalDate dateOfBirth, Gender gender, String userID,
                       String password, String email, String company) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.company = company;
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }
}
