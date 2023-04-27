package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.DeliveryModel;

@FeignClient(name = "delivery-service")
public interface DeliveryClient {
	
	@PostMapping("/core/v1/delivery")
	public ResponseEntity<DeliveryModel> getdelivery(@RequestBody DeliveryModel deliveryModel);

}
