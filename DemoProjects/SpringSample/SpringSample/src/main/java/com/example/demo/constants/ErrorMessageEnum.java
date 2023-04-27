package com.example.demo.constants;

public enum ErrorMessageEnum {
	
	DATA_NOT_FOUND(4004,"Data Not Found");
	
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
