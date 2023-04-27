package com.example.demo.exception;

public class SqlException extends RuntimeException{

	
	private int exCode;
	private String errorMessage;
	public int getExCode() {
		return exCode;
	}
	

	
	public SqlException(int exCode, String errorMessage) {
		super();
		this.exCode = exCode;
		this.errorMessage = errorMessage;
	}



	public void setExCode(int exCode) {
		this.exCode = exCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "SqlException [exCode=" + exCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
