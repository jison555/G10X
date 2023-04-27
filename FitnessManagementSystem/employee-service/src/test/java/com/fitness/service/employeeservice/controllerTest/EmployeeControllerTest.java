package com.fitness.service.employeeservice.controllerTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.fitness.service.employeeservice.controller.EmployeeController;

public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController empController;

	@Test
	@DisplayName("DemoTest1")
	public void demoTest() {

		
		System.out.println("testing	");
		
		empController.saveEmp();

	}

}
