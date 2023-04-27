package com.lms.service;

import java.util.List;

import com.lms.models.Users;

public interface UserService {
	
	public List<Users> findAll();
	public Users findOne(int id);
	public Users save(Users user);
	public void delete(int id);

}
