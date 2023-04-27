package com.example.demo.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue
	private int orderId;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Products> products;
	private double totalAmount;
	@Embedded
	private Address pickupAddress;
	private Boolean isPickup;
	@Column(name = "payed",nullable = true)
	private Boolean payed; 

}
