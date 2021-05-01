package com.emexo.hibernate.onetoone.jointable;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    @GeneratedValue
    @Column(name = "ARTICLE_ID")
    private long id;
    private String title;
    private String description;
    private String keywords;
    private String content;


}