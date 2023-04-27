package com.fitness.service.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.service.userservice.configuration.ConfigServerConfiguration;
import com.fitness.service.userservice.model.UserModel;
import com.fitness.service.userservice.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService userService;
	
	@Autowired
	private ConfigServerConfiguration configServerConfiguration;

	@Autowired
	public UserController(@Qualifier("userimpl") UserService userService) {
		System.out.println("controller created from params");
		this.userService = userService;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("executes after dependecy injection");
	}

	@PostMapping(path = "/user-fitness/users")
	public ResponseEntity<UserModel> save(@Valid @RequestBody UserModel userModel) {
		userModel = userService.save(userModel);	
		return new  ResponseEntity<UserModel>(userModel,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/user-fitness/users/{id}")
	public ResponseEntity<UserModel> findUser(@PathVariable Long id) {
		UserModel userModel = userService.findUser(id);
		return new  ResponseEntity<UserModel>(userModel,HttpStatus.OK);
	}
	
	@GetMapping(path = "/user-fitness/users")
	public ResponseEntity<List<UserModel>> findUser() {
		List<UserModel> userModel = userService.findAllUsers();
		
		//just checking the config-server working
		 System.out.println("minimum = "+configServerConfiguration.getMinimum());
		 
		return new  ResponseEntity<List<UserModel>>(userModel,HttpStatus.OK);
	}
	
	@GetMapping(path = "/user-fitness/users/mobno")
	public ResponseEntity<List<UserModel>> findUserByMobNo(@RequestParam("mobno") Long mobNo) {
		System.out.println(mobNo);
		List<UserModel> userModel = userService.findUserByMobNo(mobNo);
		return new  ResponseEntity<List<UserModel>>(userModel,HttpStatus.OK);
	}
	
	@GetMapping(path = "/user-fitness/users/employee/{id}")
	public ResponseEntity<List<UserModel>> findUsersWithEmployee(@PathVariable Long id) {
		List<UserModel> userModel = userService.findAllUsersWithTrainer(id);
		return new  ResponseEntity<List<UserModel>>(userModel,HttpStatus.OK);
	}
	
	
}
