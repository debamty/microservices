package com.coffeeshop.restapi.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CoffeeShopDemoExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)

	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(IllegalArgumentException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(HttpStatus.NOT_FOUND.value());
		response.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherException(Exception exception) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	} 

}
