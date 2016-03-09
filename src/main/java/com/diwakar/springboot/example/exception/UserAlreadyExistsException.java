package com.diwakar.springboot.example.exception;

/*
 *@author Diwakar Choudhary
 *Date: 10-March-2016
 */


public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
