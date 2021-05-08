package com.emexo.hibernate.programmatic.configuration;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue
    private long id;

    private String email;

    private String fullName;

    private String password;

    public Users(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }
}