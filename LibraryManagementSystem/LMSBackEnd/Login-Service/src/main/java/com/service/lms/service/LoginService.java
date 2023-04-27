package com.service.lms.service;

import org.springframework.stereotype.Service;

import com.service.lms.entity.User;

@Service
public interface LoginService {
	
	public User saveUser(User user);

}
