package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USER")
@Data
public class User {
	@Id
	@Column(name = "MOB_NUM")
	private long phoneNumber;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Embedded
	private Address address;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user") // working
	private Cart cart;
	private boolean isPremium;

}
