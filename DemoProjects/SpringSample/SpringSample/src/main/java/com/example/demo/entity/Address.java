package com.example.demo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String street;
	private int pinCode;
	private String state;

}
