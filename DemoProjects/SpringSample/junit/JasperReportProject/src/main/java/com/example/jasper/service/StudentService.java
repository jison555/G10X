package com.example.jasper.service;

import java.util.List;

import com.example.jasper.entity.Student;

public interface StudentService {
	
	public Student saveStudent(Student std);

	public List<Student> getAllStudents();
}
	