package com.example.demo.util;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;

@Component
public class UserModelMapperUtil {
	
	ModelMapper modelMapper;
	
	@PostConstruct
	public void modelMapperInstance() {
		modelMapper = new ModelMapper();
	}
	
	public UserModel userToUserModel(User user) {
		return modelMapper.map(user, UserModel.class);
	}
	
	public User userModelToUser(UserModel userModel) {
		return modelMapper.map(userModel, User.class);
	}

}
