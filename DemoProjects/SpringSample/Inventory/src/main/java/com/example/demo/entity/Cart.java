package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table(name = "CART")
@Entity
@Data
public class Cart{
	@Id
	@GeneratedValue
	@Column(name = "cartId")
	private int cartId;
	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
	//@JoinTable(name = "cart_prod", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "prod_id"))
	private Set<Product> products;

}
