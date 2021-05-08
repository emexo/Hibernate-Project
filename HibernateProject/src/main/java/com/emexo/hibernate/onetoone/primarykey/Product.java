package com.emexo.hibernate.onetoone.primarykey;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private long productId;

	private String name;

	private String description;

	private float price;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ProductDetail productDetail;

}