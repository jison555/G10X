package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;
import com.example.demo.model.OrderModel;
import com.example.demo.model.ProductModel;
@Component
public class ModelMapperUtils {
	
	ModelMapper modelMapper;
	
	@PostConstruct
	private void modelConstruct() {
		modelMapper = new ModelMapper();
	}
	
	public Orders ordersModelToEntity(OrderModel orderModel) {
		Orders order = new Orders();
		List<Products> prods = new ArrayList<>();
		List<ProductModel> prodModel =  orderModel.getProducts();
		for(ProductModel prodMod:prodModel) {
			prods.add( modelMapper.map(prodMod, Products.class));
		}

		order =  modelMapper.map(orderModel, Orders.class);
		order.setProducts(prods);
		return order;
	}
	
	public OrderModel orderToModel(Orders order) {
		return modelMapper.map(order, OrderModel.class);
	}
	
	public ProductModel productToModel(Products prod) {
		return modelMapper.map(prod, ProductModel.class);
	}
	
	public Products productModelToEntity(ProductModel prodModel) {
		return modelMapper.map(prodModel, Products.class);
	}
	
	

}
