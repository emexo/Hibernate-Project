package com.emexo.hibernate.onetoone.primarykey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Data
@Entity
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail {
	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name="foreigngen",
			parameters = @Parameter(name = "property", value="product"))
	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PART_NUMBER")
	private String partNumber;

	private String dimension;

	private float weight;

	private String manufacturer;

	private String origin;

	@OneToOne(mappedBy = "productDetail")
	private Product product;
	

}