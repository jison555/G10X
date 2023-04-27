package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Teachers;
import com.example.demo.exception.SqlException;

public interface TeacherService {
	
	public void insertTeacherRecord(Teachers teacher) throws SqlException;
	public Teachers findTeacher(int id);
	public List<Teachers> findAllTeachers();

}
