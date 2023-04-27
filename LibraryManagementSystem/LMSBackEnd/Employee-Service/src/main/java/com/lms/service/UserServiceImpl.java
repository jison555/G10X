package com.lms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.models.Users;

@Service
public class UserServiceImpl implements UserService {

	private static List<Users> users = new ArrayList<>();

	static {

		users.add(new Users(1, "gokul", LocalDateTime.now()));
		users.add(new Users(2, "sam", LocalDateTime.now()));
		users.add(new Users(3, "shiva", LocalDateTime.now()));
	}

	@Override
	public List<Users> findAll() {

		return users;
	}

	@Override
	public Users findOne(int id) {

		return users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Users save(Users user) {

		users.add(user);
		return user;

	}

	@Override
	public void delete(int id) {
		users.stream().filter(user -> user.getId() == id).map(users::remove).forEach(System.out::print);

	}

}
