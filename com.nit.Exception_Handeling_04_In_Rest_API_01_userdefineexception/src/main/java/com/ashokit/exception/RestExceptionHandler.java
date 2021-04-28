package com.ashokit.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {


	/*	Without error message
		@ExceptionHandler(value=NoProductFoundException.class)
		public ResponseEntity handleNoProductFoundException() {

			ApiError apiError = new ApiError(400,"No Data Found",new Date());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}*/
	@ExceptionHandler(value=NoProductFoundException.class)	
	public ResponseEntity<ApiError> handleNoProductFoundException() {

		ApiError error = new ApiError(400,"No Product Found",new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);

	}	

}
