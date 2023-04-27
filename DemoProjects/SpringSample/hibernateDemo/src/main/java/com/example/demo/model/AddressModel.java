package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.entity.Person;

import lombok.Data;

@Data
public class AddressModel {

	@Id
	@GeneratedValue
	private int houseNumber;
	private String hName;
	private Person person;	

}
