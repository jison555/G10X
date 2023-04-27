package com.example.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class demoController {
	@GetMapping
	public void getData() {
		System.out.println("dataaaaaaaaaaaaaaaaaaaaa");
	}

}
