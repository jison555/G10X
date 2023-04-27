package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Teachers;
import com.example.demo.service.TeacherServiceImpl;

@RestController
@RequestMapping("/teacher")
public class TeachersController {
	
	@Autowired
	TeacherServiceImpl teacherService;
	
	@PostMapping("/addTeacher")
	public void addTeacher(@RequestBody Teachers teacher) {
		 teacherService.insertTeacherRecord(teacher);	
	}
	
	@GetMapping("/getAllTeachers")
	public List<Teachers> getAllTeacher() {	
		System.out.println("Hii");
		 return teacherService.findAllTeachers();	
	}
	
	@GetMapping("/getTeacher/{id}")
	public Teachers getTeacher(@PathVariable int id) {
		 return teacherService.findTeacher(id);
	}
		
	
	
	

}
