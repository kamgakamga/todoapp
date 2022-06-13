package com.if5.todoapp.exceptions.Ex;

import java.util.List;

public class InvalidEntityException  extends RuntimeException{

	private ErrorCodes errorCodes;
	private List<String> errors;
	
	
	
	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public InvalidEntityException(String message) {
		super(message);
	}
	public InvalidEntityException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes ) {
		super(message,cause);
		this.errorCodes = errorCodes; 
	}
	public InvalidEntityException(String message, ErrorCodes errorCodes,List<String> errors) {
		super(message);
		this.errorCodes = errorCodes; 
		this.errors = errors;
	}
}
