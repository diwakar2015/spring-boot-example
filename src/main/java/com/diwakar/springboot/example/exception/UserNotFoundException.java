package com.diwakar.springboot.example.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(final String message) {
		super(message);
	}
}
