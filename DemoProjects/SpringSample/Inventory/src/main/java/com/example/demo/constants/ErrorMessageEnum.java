package com.example.demo.constants;

public enum ErrorMessageEnum {
	
	DATA_NOT_FOUND(404,"Data Not Found"),
	USER_ALREADY_EXIST(404,"USER_ALREADY_EXIST");
	
	private final int errorCode;
	private final String errorMessage;
	
	private ErrorMessageEnum(int errorCode,String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	

}
