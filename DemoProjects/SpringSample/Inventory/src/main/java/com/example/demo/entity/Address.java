package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Data
public class Address {
	@Column(name = "PINCODE")
	private int pincode;
	@Column(name = "HOUSE_NUMBER")
	private String houseNumber;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "STATE")
	private String state;

}
