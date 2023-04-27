package com.example.demo.model;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

import lombok.Data;

@Data
public class CartModel {

	private int cartId;
	private UserModel user;
	private List<ProductModel> products;

}
