package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.DeliveryClient;
import com.example.demo.model.DeliveryModel;
@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	
	@Autowired
	DeliveryClient deliveryClient;


	@Override
	public DeliveryModel postDelivery(DeliveryModel deliveryModel) {
		ResponseEntity<DeliveryModel> ResDeliveryModel = deliveryClient.getdelivery(deliveryModel);
		return ResDeliveryModel.getBody();
	}
}
