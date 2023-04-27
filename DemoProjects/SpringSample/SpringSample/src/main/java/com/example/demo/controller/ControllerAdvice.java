package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.constants.ErrorMessageEnum;
import com.example.demo.exception.ApiError;
import com.example.demo.exception.NoDataFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(NoDataFoundException.class)
	public ApiError noDataFoundException(NoDataFoundException ndfEx) {
		return new ApiError(ErrorMessageEnum.DATA_NOT_FOUND.getErrorCode(),
				ErrorMessageEnum.DATA_NOT_FOUND.getErrorMessage());

	}

}
