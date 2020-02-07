package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorBean> invalidVinException(InvalidVinException e){
		
		CustomErrorBean error = new CustomErrorBean();
		error.setMessage("Invalid Vehicle Identification Number");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomErrorBean>(error,HttpStatus.BAD_REQUEST);
	}

}
