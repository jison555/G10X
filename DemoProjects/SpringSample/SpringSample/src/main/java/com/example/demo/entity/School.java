package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class School { 
	@Id
	@GeneratedValue
	private int code;
	private String name;
	private Address address;
	@OneToMany
	@JoinTable(name = "SCHOOL_STUDENT_TABLE")
	private List<Students> students;
	
	

}
