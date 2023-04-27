package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Students;

public interface StudentService {

	public Students addMarks(Students std);

	public Students getMark(Integer id);

	public List<Students> getAllMark();

	public String updateMarks(Students std);

	public String deleteMarks(int id);

	public List<Students> findbyFavSub(String sub);

	public List<Students> findbyFavSub(int id);

	public void updateSubById(String sub, int id);

}
