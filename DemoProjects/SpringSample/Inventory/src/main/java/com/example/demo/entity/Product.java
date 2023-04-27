package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT", schema = "IMS")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(generator = "custom-generator",strategy =
	// GenerationType.IDENTITY)
	// @GenericGenerator(name = "custom-generator",strategy =
	// "com.example.demo.util.IdGenerator")
	@Column(name = "PRODUCT_ID")
	private int prodId;
	@Column(name = "PROD_NAME")
	private String name;
	@Column(name = "PRICE_PER_UNIT")
	private double price;
	@Column(name = "DISCRIPTION")
	private String discription;
	@Column(name = "STOCK_LEVEL")
	private int stockLevel;
	@Column(name = "MANUFACTURE_DATE")
	private Date manDate;
	@Column(name = "EXPIRE_DATE")
	private Date expDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	@JsonManagedReference
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inv_id")
	private Inventory inventory;
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "LOC_ID")
//	private Location location;
	@Column(name = "NEXT_ARRIVAL")
	private Date nextArrival;

	
	
}
