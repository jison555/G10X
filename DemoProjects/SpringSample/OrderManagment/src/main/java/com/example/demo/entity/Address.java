package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Embeddable
@Data
public class Address {
	
	@Column(name = "PINCODE")
	private int pincode;
	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;
	@Column(name = "DISTRICT")
	private String District;
	@Column(name = "STATE")
	private String state;
}
