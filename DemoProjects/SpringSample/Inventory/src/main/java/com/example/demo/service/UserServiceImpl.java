package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.exception.UserExistException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepo;
import com.example.demo.util.UserModelMapperUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserModelMapperUtil userMapper;

	@Override
	public UserModel addUser(UserModel userModel) throws UserExistException {
		User user =  userMapper.userModelToUser(userModel);
		//user.getCart().setUser(user);
		Optional<User> optUser = userRepo.findById(user.getPhoneNumber());
		if(optUser.isPresent()) {
			throw new UserExistException();
		}
		Cart cart =  new Cart();
		cart.setUser(user);
		user.setCart(cart);
		user = userRepo.save(user);
		return userMapper.userToUserModel(user);	

	}

	@Override
	public UserModel getUser(Long mob) {
		Optional<User> opUser = userRepo.findById(mob);
		if(opUser.isPresent()) {
			return userMapper.userToUserModel(opUser.get());
		}
		return null;
	}

}
