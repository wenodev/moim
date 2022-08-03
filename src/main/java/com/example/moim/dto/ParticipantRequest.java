package com.example.moim.dto;

import com.example.moim.domain.Gender;

import java.time.LocalDate;
import java.util.List;

public class ParticipantRequest {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String userID;
    private String password;
    private String email;
    private List<String> ingredients;
    private String introduction;

    public ParticipantRequest(String name, LocalDate dateOfBirth, Gender gender, String userID, String password,
                              String email, List<String> ingredients, String introduction) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userID = userID;
        this.password = password;
        this.email = email;
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

    public String getUserID() {
        return userID;
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
