package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Hobbies;
import com.example.demo.entity.Person;
import com.example.demo.repository.HobbiesRepo;
import com.example.demo.repository.PersonRepo;

@RestController
@RequestMapping("/v1/core")
public class PersonController {

	public PersonController() {
		System.out.println("hiii in ontroller");
	}

	@Autowired	
	PersonRepo repo;
	
	@Autowired	
	HobbiesRepo repohobby;
	

	@PostMapping(path = "/postData")
	public String demoMeth() {
		Address address = new Address();
		address.setHName("asc222");
		Person person = new Person();
		List<Hobbies> hobbies = Arrays.asList(new Hobbies("football",person),new Hobbies("Drums",person));
		person.setName("Ram Kumar");
		person.setAddress(address);
		person.setHobbies(hobbies);
		person =  repo.save(person);


//		Hobbies hobby = new Hobbies();
//		hobby.setName("chess");
//		hobby.setPerson(person);
//		repohobby.save(hobby);
		return "done";
	}
	
	@GetMapping(path = "/getData")
	public List<Person> getData() {
		List<Person> persons =   repo.findAll();
		if(persons.size()>0) {
			for(Hobbies hobby :persons.get(0).getHobbies()) {
				System.out.println("hobby = "+hobby.getName());
			}
		}
		return persons;
		
	}

}
