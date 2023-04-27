package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;
	
@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
