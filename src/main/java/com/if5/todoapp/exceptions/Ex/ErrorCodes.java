package com.if5.todoapp.exceptions.Ex;

public enum ErrorCodes {
	APPUSER_NOT_FOUND(10),
	APPUSER_NOT_VALID(11),
	APPTASK_NOT_FOUND(20),
	APPTASK_NOT_VALID(21);

	private int code;

	
	private ErrorCodes(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
