package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Teachers;
import com.example.demo.exception.SqlException;
import com.example.demo.repository.TeacherRepoImpl;
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepoImpl teacherRepo;

	@Override
	@Transactional
	public void insertTeacherRecord(Teachers teacher) throws SqlException {
	
		teacherRepo.insertTeacherRecord(teacher);
	}

	@Override
	public List<Teachers> findAllTeachers() {
		return teacherRepo.findAllTeachers();
	}

	@Override
	public Teachers findTeacher(int id) {
		
		return teacherRepo.findTeacher(id);
	}

}
