package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.OrderModel;
import com.example.demo.model.UserModel;

@Service
public interface OrderService {

	public  ResponseEntity<UserModel> getUserDetails(Long mob);

	public OrderModel placeOrder(OrderModel orders,UserModel user) throws NoDataFoundException;

}
