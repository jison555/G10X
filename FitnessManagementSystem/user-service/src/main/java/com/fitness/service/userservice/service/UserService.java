package com.fitness.service.userservice.service;

import java.util.List;

import com.fitness.service.userservice.model.UserModel;

public interface UserService {
	
	public UserModel save(UserModel user);
	public UserModel findUser(Long id);
	public List<UserModel> findAllUsers();
	public List<UserModel> findUserByMobNo(Long mobNo);
	public List<UserModel> findAllUsersWithTrainer(Long id);

}
