package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Address;

import lombok.Data;
@Data
public class OrderModel {
	
	
	public OrderModel() {
		this.payed=false;
	}
	
	private List<ProductModel> products;
	private double totalAmount;
	private Boolean payed;
	private Boolean isPickup;
	private Address pickupAddress;
}
