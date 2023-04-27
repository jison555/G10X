package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.constants.ErrorMessageEnum;
import com.example.demo.exception.ApiError;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.exception.UserExistException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(NoDataFoundException.class)
	public ApiError noDataFoundException(NoDataFoundException ndfEx) {
		return new ApiError(ErrorMessageEnum.DATA_NOT_FOUND.getErrorCode(),
				ErrorMessageEnum.DATA_NOT_FOUND.getErrorMessage());

	}	
	
	@ExceptionHandler(UserExistException.class)
	public ApiError userExistException(UserExistException ndfEx) {
		return new ApiError(ErrorMessageEnum.USER_ALREADY_EXIST.getErrorCode(),
				ErrorMessageEnum.USER_ALREADY_EXIST.getErrorMessage());

	}	
	
	
	@ExceptionHandler(Exception.class)
	ApiError exception(Exception ndfEx) {
		return new ApiError(404,"no userExist or Cart Found");

	}	

}
