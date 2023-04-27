package com.udemy.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservices.bean.Limits;
import com.udemy.microservices.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimits() {	
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}

}
