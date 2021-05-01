package com.emexo.hibernate.onetoone.foreignkey;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AUTHOR")
public class Author {
    @Id
    @Column(name = "AUTHOR_ID")
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "author")
    private Book book;

}