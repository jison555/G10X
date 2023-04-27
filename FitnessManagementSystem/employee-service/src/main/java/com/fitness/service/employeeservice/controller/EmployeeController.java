package com.fitness.service.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.service.employeeservice.model.EmployeeModel;

@RestController
public class EmployeeController {
	
	@PostMapping(path = "/employee-fitness/employees")
	public ResponseEntity<String> saveEmp(){
		return ResponseEntity.status(HttpStatus.CREATED).body("success");
	}
	
	@GetMapping(path = "/employee-fitness/employees")
	public ResponseEntity<String> getAllEmp(){
		return ResponseEntity.status(HttpStatus.OK).body("success");
	}
	
	@GetMapping(path = "/employee-fitness/employees/{id}")
	public ResponseEntity<EmployeeModel> getTrainer(@PathVariable Long id){
		System.out.println(" im here----------------");
		EmployeeModel emp = new EmployeeModel(1L, "Varun");
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}

}
