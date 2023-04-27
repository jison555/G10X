package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Teachers;

public interface TeacherRepo {
	
	public void insertTeacherRecord(Teachers teacher);
	public Teachers findTeacher(int id);
	public List<Teachers> findAllTeachers();
	

}
