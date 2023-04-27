package com.example.demo.model;

import lombok.Data;

@Data
public class DeliveryModel {

	public DeliveryModel() {
		super();
		this.status = "dispatched";
	}

	private OrderModel orderDetails;
	private UserModel userDetails;
	private String status;

}
