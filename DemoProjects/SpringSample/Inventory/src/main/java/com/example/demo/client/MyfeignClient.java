package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "billing-service")
public interface MyfeignClient {
	
	@GetMapping("/billing/getBill")
	public String getBilling();

}
