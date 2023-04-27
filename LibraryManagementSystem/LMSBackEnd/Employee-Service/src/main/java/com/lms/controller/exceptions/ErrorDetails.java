package com.lms.controller.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String details;
	

}
