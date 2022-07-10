package com.example.moim.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String userID;
    private String password;
    private String email;
    private String company;

    public Member() {
    }

    public Member(String name, LocalDate dateOfBirth, Gender gender, String userID,
                  String password, String email, String company) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userID = userID;
        this.password = password;
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
