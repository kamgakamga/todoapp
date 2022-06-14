package com.if5.todoapp.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handlerInvalidArgument(MethodArgumentNotValidException ex){
		 
		Map<String,String> errorsMap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			        errorsMap.put(error.getField(),error.getDefaultMessage());
		} );
		return errorsMap;
		
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EntityNotFoundException.class)
	public Map<String,String> handlerUserException(EntityNotFoundException ex){
		 
		Map<String,String> errorUserMap= new HashMap<>();
		errorUserMap.put("error", ex.getMessage());
		return errorUserMap;	
	}
	
	
}
