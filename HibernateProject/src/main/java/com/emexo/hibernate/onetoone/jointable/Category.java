package com.emexo.hibernate.onetoone.jointable;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_ARTICLE",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID")
    )
    private Article article;

}