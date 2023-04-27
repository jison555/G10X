package com.example.demo.util;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Delivery;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;
import com.example.demo.model.DeliveryModel;
import com.example.demo.model.OrderModel;
import com.example.demo.model.ProductModel;
@Component
public class ModelMapperUtils {
	
	ModelMapper modelMapper;
	
	@PostConstruct
	private void modelConstruct() {
		modelMapper = new ModelMapper();
	}
	
	public Delivery deliveryModelToEntity(DeliveryModel deliveryModel) {
		modelMapper.map(deliveryModel.getOrderDetails(), Orders.class);
		return modelMapper.map(deliveryModel, Delivery.class);
	}
	
	public DeliveryModel dliveryToModel(Delivery delivery) {
		OrderModel ordModel =  modelMapper.map(delivery.getOrders(), OrderModel.class);
		DeliveryModel delModel =  modelMapper.map(delivery, DeliveryModel.class);
		delModel.setOrderDetails(ordModel);
		return delModel;
	}
	
	public ProductModel productToModel(Products prod) {
		return modelMapper.map(prod, ProductModel.class);
	}
	
	public Products productModelToEntity(ProductModel prodModel) {
		return modelMapper.map(prodModel, Products.class);
	}
	
	public OrderModel orderToModel(Orders order) {
		return modelMapper.map(order, OrderModel.class);
	}
	
	public Orders orderModelToEntity(OrderModel orderModel) {
		return modelMapper.map(orderModel, Orders.class);
	}
	

	
	

}
