package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
	// private long userId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products;
	private double totalAmount;
	private Boolean isPickup;
	@Embedded
	private Address pickupAddress;
	private Boolean payed;

}
