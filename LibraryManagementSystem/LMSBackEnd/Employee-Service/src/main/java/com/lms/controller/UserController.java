package com.lms.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lms.controller.exceptions.UserNotFoundException;
import com.lms.models.Users;
import com.lms.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(path = "/users")
	public List<Users> getAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Users getUsersById(@PathVariable int id) {
		Users user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id= " + id);
		}
		return user;
	}

	@PostMapping("/users")	
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		System.out.println("posting");
		Users savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUsersById(@PathVariable int id) {
		service.delete(id);

	}

}
