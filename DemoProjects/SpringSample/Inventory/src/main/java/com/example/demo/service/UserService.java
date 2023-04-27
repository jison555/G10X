package com.example.demo.service;

import com.example.demo.exception.UserExistException;
import com.example.demo.model.UserModel;

public interface UserService {

	public UserModel addUser(UserModel userModel)  throws UserExistException;
	public UserModel getUser(Long mob);

}
