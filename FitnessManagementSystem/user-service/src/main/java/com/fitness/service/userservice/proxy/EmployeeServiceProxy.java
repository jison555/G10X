package com.fitness.service.userservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fitness.service.userservice.model.EmployeeModel;

@FeignClient("employee-fitness-service")
public interface EmployeeServiceProxy {

	@GetMapping(path = "/employee-fitness/employees/{id}")
	public ResponseEntity<EmployeeModel> getTrainer(@PathVariable Long id);

}
