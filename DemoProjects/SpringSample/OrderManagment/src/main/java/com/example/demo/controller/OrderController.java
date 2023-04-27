package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.DeliveryModel;
import com.example.demo.model.OrderModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping(path = "/core/v1")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	DeliveryService deliveryService;

	@PostMapping(path = "/order")
	public ResponseEntity<DeliveryModel> placeOrder(@RequestBody OrderModel orderModel, @RequestParam Long mob)
			throws NoDataFoundException {
		 UserModel uModel= orderService.getUserDetails(mob).getBody();

		orderModel = orderService.placeOrder(orderModel,uModel);
		DeliveryModel deliveryModel = new DeliveryModel();
		deliveryModel.setOrderDetails(orderModel);
		deliveryModel = deliveryService.postDelivery(deliveryModel);
		deliveryModel.setUserDetails(uModel);
		return ResponseEntity.accepted().body(deliveryModel);

	}

//	@GetMapping("/testing")
//	public Delivery del() {
//		return deliveryClient.getdelivery(new Delivery());
//	}

}
