package com.example.demo.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.model.AddressModel;
import com.example.demo.repository.AddressRepo;

@RestController
@RequestMapping("/v1/core")
public class AddressController {

	public AddressController() {
		System.out.println("hiii in ontroller");
	}
	
	@Autowired
	AddressRepo repo;

	ModelMapper modelMapper;

	@PostConstruct
	public void modelMapperInstance() {
		modelMapper = new ModelMapper();
	}

	@GetMapping("/address/{id}")
	public Address getAddressById(@PathVariable int id) {
		Optional<Address> optAddress = repo.findById(id);
		AddressModel addModel = null;

		Address address = null;
		if (optAddress.isPresent()) {
			address = optAddress.get();
			addModel = this.modelMapper.map(address, AddressModel.class);
			address = this.modelMapper.map(addModel, Address.class);
		}
		address = repo.save(address);
		return address;

	}
}
