package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DeliveryModel;

public interface DeliveryService {
	
	public DeliveryModel saveDelivery(DeliveryModel deliveryModel);
	public List<DeliveryModel> getAllDeliveries();
	public DeliveryModel changeStatus(int id,String status);

}
