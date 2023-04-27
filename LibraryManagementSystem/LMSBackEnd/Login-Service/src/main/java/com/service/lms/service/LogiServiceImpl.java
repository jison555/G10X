package com.service.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.lms.entity.User;
import com.service.lms.repository.UserRepository;

@Service
public class LogiServiceImpl implements LoginService {
	
	@Autowired
	UserRepository loginRepo;

	@Override
	public User saveUser(User user) {
		
		return loginRepo.save(user);
	}

}
