package com.example.user.exception.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.user.exception.ErrorMessage;
import com.example.user.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorMessage error = new ErrorMessage(LocalDateTime.now(),"internal server error","error details");
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(UserNotFoundException resoureNotFoundException, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), resoureNotFoundException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> resourceNotFoundException(Exception exception, WebRequest webRequest){
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
