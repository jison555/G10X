package com.example.demo.controllerTest;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Students;
import com.example.demo.service.StudentServiceImpl;



public class StudentControllerTest {
	
	@InjectMocks
	private StudentController stdController;
	
	@Mock
	private StudentServiceImpl service;
	
	@Test
	@DisplayName("getAllMark")
	public void getAllMarkTest() {
		List<Students> listStudents = new ArrayList<>();
		when(service.getAllMark()).thenReturn(listStudents);
		
		stdController.getAllMark();
	}

}
