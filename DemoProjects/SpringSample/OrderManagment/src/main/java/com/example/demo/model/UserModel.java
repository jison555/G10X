package com.example.demo.model;

import com.example.demo.entity.Address;

import lombok.Data;

@Data
public class UserModel {

	private long phoneNumber;

	private String name;

	private Address address;	

	private boolean isPremium;

}
