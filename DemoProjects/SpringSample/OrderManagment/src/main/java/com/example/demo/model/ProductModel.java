package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class ProductModel {
	
	private int prodId;
	private String name;
	private double price;
	private int stockLevel;

	
}
