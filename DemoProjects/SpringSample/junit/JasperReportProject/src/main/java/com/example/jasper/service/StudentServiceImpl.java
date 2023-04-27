package com.example.jasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jasper.entity.Student;
import com.example.jasper.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo repo;

	@Override
	public Student saveStudent(Student std) {
		return repo.save(std);
		
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

}
