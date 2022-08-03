package com.example.moim.dto;

import com.example.moim.domain.Gender;
import com.example.moim.domain.Ingredients;
import com.example.moim.domain.Member;

import java.time.LocalDate;
import java.util.List;

public class ParticipantResponse {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String userID;
    private String email;
    private List<String> ingredients;
    private String introduction;

    public static ParticipantResponse of(Member member) {
        return new ParticipantResponse(member.getId(), member.getName(), member.getDateOfBirth(), member.getGender(),
                member.getUserID(), member.getEmail(), Ingredients.convertString(member.getIngredients()), member.getIntroduction());
    }

    public ParticipantResponse(Long id, String name, LocalDate dateOfBirth, Gender gender, String userID, String email,
                               List<String> ingredients, String introduction) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userID = userID;
        this.email = email;
        this.ingredients = ingredients;
        this.introduction = introduction;
    }

    public ParticipantResponse() {
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getIntroduction() {
        return introduction;
    }
}
