package com.fitness.service.userservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.service.userservice.entity.UserEntity;
import com.fitness.service.userservice.exception.UserNotFoundException;
import com.fitness.service.userservice.model.EmployeeModel;
import com.fitness.service.userservice.model.UserModel;
import com.fitness.service.userservice.proxy.EmployeeServiceProxy;
import com.fitness.service.userservice.repository.UserRepository;
import com.fitness.service.userservice.utils.UserModelMapperUtil;

@Service("userimpl")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserModelMapperUtil userModelMapper;

	private EmployeeServiceProxy employeeProxy;

	public UserServiceImpl(@Autowired UserRepository userRepository, @Autowired UserModelMapperUtil userModelMapper,@Autowired EmployeeServiceProxy employeeProxy) {
		this.userRepository = userRepository;
		this.userModelMapper = userModelMapper;
		this.employeeProxy = employeeProxy;
	}

	@Override
	public UserModel save(UserModel userModel) {
		UserEntity user = userModelMapper.convertUserModelToEntity(userModel);
		user = userRepository.save(user);
		userModel = userModelMapper.convertUserEntityToModel(user);
		return userModel;
	}

	@Override
	public UserModel findUser(Long id) {
		UserEntity user;
		if (userRepository.findById(id).isPresent()) {
			user = userRepository.findById(id).get();
			UserModel userModel = userModelMapper.convertUserEntityToModel(user);
			return userModel;

		} else {
			throw new UserNotFoundException(id + " is not present ");
		}
	}

	@Override
	public List<UserModel> findAllUsers() {
		List<UserEntity> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserNotFoundException("Users not present");
		}
		List<UserModel> userModels = users.stream().map(x -> {
			return userModelMapper.convertUserEntityToModel(x);
		}).collect(Collectors.toList());
		return userModels;
	}

	@Override
	public List<UserModel> findUserByMobNo(Long mobNo) {
		List<UserEntity> users = userRepository.findByMobNo(mobNo);
		if (users.isEmpty()) {
			throw new UserNotFoundException("Users not present");
		}
		List<UserModel> userModels = users.stream().map(x -> {
			return userModelMapper.convertUserEntityToModel(x);
		}).collect(Collectors.toList());
		return userModels;
	}

	@Override
	public List<UserModel> findAllUsersWithTrainer(Long id) {
		List<UserEntity> userEntities;
		List<UserModel> userModels = null;
		EmployeeModel emp = employeeProxy.getTrainer(id).getBody();
		if (Optional.ofNullable(emp).isPresent()) {
			userEntities = userRepository.findByTrainer(emp.getEmployeeId());
			userModels = userEntities.stream().map(userModelMapper::convertUserEntityToModel)
					.collect(Collectors.toList());
			return userModels;
		} else {
			throw new UserNotFoundException("Users not present");
		}

	}

}
