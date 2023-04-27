package com.fitness.service.userservice.model;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
	
	private Long userId;
	@NotNull
	@Size(min = 2, message = "name should have atlast 2 character")
	private String name;
	@NotNull
	private Long mobNo;
	private Long trainer;
	private LocalTime preferedTime;

}
