package com.udemy.microservices.curencyExchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api",fallbackMethod = "hardCodedValue")
	public String sampleApi() {
		int count=1;
		logger.info("Sample api call received for {}",count++);
// any Exception occurs it calls the fallBackMethod corresponding corresponig to that Exception
		int a = 4/0;
		return "sample api";
	}
	
	public String hardCodedValue(ArithmeticException ex) {
		return "default response";
	}

}
