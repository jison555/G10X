package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.URIConstants;
import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;

@RestController
@RequestMapping(path = URIConstants.BASE_URL)
public class LocationController {
	
	@Autowired
	LocationService locService;
	
	@PostMapping(path="/location")
	public ResponseEntity<Location> saveLocation(@RequestBody Location loc) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(locService.addLocation(loc));
	}

}
