package com.example.demo.model;

import com.example.demo.entity.Address;
import com.example.demo.entity.Cart;

import lombok.Data;

@Data
public class UserModel {

	private long phoneNumber;

	private String name;

	private String password;

	private Address address;

	private Cart cart;
	
	private boolean isPremium;

}
