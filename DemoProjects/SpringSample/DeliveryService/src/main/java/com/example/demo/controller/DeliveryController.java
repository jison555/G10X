package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Delivery;
import com.example.demo.model.DeliveryModel;
import com.example.demo.service.DeliveryService;

@RestController
@RequestMapping(path = "/core/v1")
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;

	// call from order-service
	@PostMapping("/delivery")
	public ResponseEntity<DeliveryModel> getDelivery(@RequestBody DeliveryModel deliveryModel) {
		System.out.println("item delivered");
		return ResponseEntity.status(HttpStatus.OK).body(deliveryService.saveDelivery(deliveryModel));
	}

	// get all deliveries
	@GetMapping("/delivery")
	public ResponseEntity<List<DeliveryModel>> getAllDelivery() {
		return ResponseEntity.status(HttpStatus.OK).body(deliveryService.getAllDeliveries());
	}

	// get delivery by ID and change delivery status
	@PutMapping("/delivery/{id}")
	public ResponseEntity<DeliveryModel> changeStatus(@PathVariable int id,@RequestBody String status) {
		return ResponseEntity.status(HttpStatus.OK).body(deliveryService.changeStatus(id, status));
	}

}
