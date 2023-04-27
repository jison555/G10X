package com.fitness.service.userservice.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue
	private Long userId;
	private String name;
	private Long mobNo;
	private Long trainer;
	private LocalTime preferedTime;

	public UserEntity(String name, Long mobNo, Long trainer, LocalTime preferedTime) {
		super();
		this.name = name;
		this.mobNo = mobNo;
		this.trainer = trainer;
		this.preferedTime = preferedTime;
	}

}
