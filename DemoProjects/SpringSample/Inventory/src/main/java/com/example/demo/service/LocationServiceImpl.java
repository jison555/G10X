package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationRepository locRepo;

	@Override
	public Location addLocation(Location loc) {
	
		return locRepo.save(loc);
	}

}
