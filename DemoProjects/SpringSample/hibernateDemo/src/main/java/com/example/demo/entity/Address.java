package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue
	private int houseNumber;
	private String hName;
	@OneToOne(mappedBy = "address")
	private Person person;

}
	