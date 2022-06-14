package com.if5.todoapp.exceptions.handler;

public class EntityNotFoundException extends Exception{

	private ErrorCodes errorCodes;
	
	
	
	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}
	
	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes ) {
		super(message,cause);
		this.errorCodes = errorCodes; 
	}
	
	
	public EntityNotFoundException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes; 
	}
}
