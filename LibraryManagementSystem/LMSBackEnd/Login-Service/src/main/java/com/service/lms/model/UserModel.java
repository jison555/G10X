package com.service.lms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private Long id;
	private String userName;
	private String email;
	private String password;
}
