package com.example.demo.util;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Cart;
import com.example.demo.model.CartModel;

@Component
public class CartModelMapperUtil {
	
	ModelMapper modelMapper;
	
	@PostConstruct
	public void modelMapperInstance() {
		modelMapper = new ModelMapper();
	}
	
	public CartModel CartToCartModel(Cart Cart) {
		return modelMapper.map(Cart, CartModel.class);
	}
	
	public Cart CartModelToCart(CartModel CartModel) {
		return modelMapper.map(CartModel, Cart.class);
	}

}
