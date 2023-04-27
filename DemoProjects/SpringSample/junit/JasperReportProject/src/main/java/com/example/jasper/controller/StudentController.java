package com.example.jasper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jasper.entity.Student;
import com.example.jasper.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping(value = "/save")
	public Student saveStd(@RequestBody Student std) {
		return service.saveStudent(std);
	}
	
	@GetMapping(value = "/getAll")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	

}
