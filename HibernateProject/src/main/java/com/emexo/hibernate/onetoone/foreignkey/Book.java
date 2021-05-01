package com.emexo.hibernate.onetoone.foreignkey;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "PUBLISHED")
    private Date publishedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

}