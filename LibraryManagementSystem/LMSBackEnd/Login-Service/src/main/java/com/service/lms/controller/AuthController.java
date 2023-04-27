package com.service.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.lms.dto.LoginDto;
import com.service.lms.service.LoginService;

@RestController
@RequestMapping("/api/auth")
//@RequestMapping(path = "/")
public class AuthController {

	@Autowired
	LoginService loginService;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@PostMapping(path = "/")
//	public User saveUser(@RequestBody User user) {
//		System.out.println(user);
//		return loginService.saveUser(user);
//	}

	@PostMapping(path = "/signin")
	public void saveUser(@RequestBody LoginDto loginDto) {
		System.out.println("hiiii");
//		Authentication authentication = manager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);

	}

	@GetMapping(path = "/user")
	public String user() {

		return "hii all";
	}

	@GetMapping(path = "/admin")
	public String admin() {
		return "hii admin";
	}

}
