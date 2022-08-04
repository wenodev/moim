package com.example.moim.member.domain;

import com.example.moim.common.ErrorMessage;
import com.example.moim.common.NotMatchException;
import com.example.moim.utils.CipherGenerator;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String memberId;
    private String password;
    private String email;
    private String company;
    private String introduction;
    @Embedded
    private Ingredients ingredients;

    public static Member createHost(String name, LocalDate dateOfBirth, Gender gender, String userID,
                                    String password, String email, String company) {
        return new Member(name, dateOfBirth, gender, userID, password, email, company);
    }

    public static Member createParticipant(String name, LocalDate dateOfBirth, Gender gender, String userID,
                                           String password, String email, List<String> ingredients, String introduction) {
        return new Member(name, dateOfBirth, gender, userID, password, email, ingredients, introduction);
    }

    public Member(String name, LocalDate dateOfBirth, Gender gender, String memberID, String password, String email, List<String> ingredients, String introduction) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.memberId = memberID;
        this.password = password;
        this.email = email;
        this.ingredients = new Ingredients(ingredients);
        this.introduction = introduction;
    }

    public Member(String name, LocalDate dateOfBirth, Gender gender, String memberID,
                  String password, String email, String company) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.memberId = memberID;
        this.password = password;
        this.email = email;
        this.company = company;
    }

    public Member() {
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

    public String getMemberId() {
        return memberId;
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

    public String getIntroduction() {
        return introduction;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void checkPassword(String password) {
        if (!this.password.equals(CipherGenerator.encode(password))) {
            throw new NotMatchException(ErrorMessage.PASSWORD_NOT_MATCH);
        }
    }
}
