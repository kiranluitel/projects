package com.example.demo.exceptions;

public class InvalidVinException extends RuntimeException{
	
	
	public InvalidVinException() {
		
	}

	public InvalidVinException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidVinException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidVinException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
