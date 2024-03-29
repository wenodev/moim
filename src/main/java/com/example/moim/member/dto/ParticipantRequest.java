package com.example.moim.member.dto;

import com.example.moim.member.domain.Gender;

import java.time.LocalDate;
import java.util.List;

public class ParticipantRequest {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String memberId;
    private String password;
    private String email;
    private List<String> ingredients;
    private String introduction;

    public ParticipantRequest(String name, LocalDate dateOfBirth, Gender gender, String memberId, String password,
                              String email, List<String> ingredients, String introduction) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.ingredients = ingredients;
        this.introduction = introduction;
    }

    public ParticipantRequest(String name, LocalDate dateOfBirth, Gender gender,
                              String memberId, List<String> ingredients, String introduction) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.memberId = memberId;
        this.ingredients = ingredients;
        this.introduction = introduction;
    }

    public ParticipantRequest() {
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

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getIntroduction() {
        return introduction;
    }
}
