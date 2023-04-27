package com.lms.models;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;	
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Users {

	private int id;
	@Size(min = 2, message = "name should have atlast 2 character")
	private String name;
	@Past(message = "birthday should be in the past")
	private LocalDateTime date;

}
