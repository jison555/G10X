package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.URIConstants;
import com.example.demo.exception.UserExistException;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)
public class UserController {

	@Autowired	
	UserService userService;

	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) throws UserExistException {
		userModel = userService.addUser(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
	}

	@GetMapping(path = "/user")
	public ResponseEntity<UserModel> getUser(@RequestParam Long mob ) {
		UserModel uModel =  userService.getUser(mob);
		return ResponseEntity.status(HttpStatus.CREATED).body(uModel);
	}
}
