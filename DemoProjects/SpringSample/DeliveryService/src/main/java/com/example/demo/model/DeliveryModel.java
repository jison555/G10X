package com.example.demo.model;

public class DeliveryModel {
	
	
	
	public DeliveryModel() {
		super();
		this.status = "dispatched";
	}
	private OrderModel orderDetails;
	private String status;
	
	public OrderModel getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderModel orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
