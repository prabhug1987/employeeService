package com.example.employee.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resoureNotFoundException, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), resoureNotFoundException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> resourceNotFoundException(Exception exception, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
