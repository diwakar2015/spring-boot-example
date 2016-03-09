package com.diwakar.springboot.example.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.diwakar.springboot.example.domain.User;
import com.diwakar.springboot.example.exception.UserAlreadyExistsException;
import com.diwakar.springboot.example.exception.UserNotFoundException;
import com.diwakar.springboot.example.service.UserService;


/*
 *@author Diwakar Choudhary
 *Date: 10-March-2016
 */

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	@Inject
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User createUser(@RequestBody @Valid final User user) {
		LOGGER.debug("Received request to create the {}", user);
		return userService.save(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateUser(@RequestBody @Valid final User user) {
		LOGGER.debug("Received request to update {} ", user);
		userService.update(user);
		return user;
	}


	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteAllUsers(@PathVariable("id") String id) {
		LOGGER.debug("Received request to delete all the users");
		userService.deleteAll();

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteUser(@PathVariable("id") String id) {
		LOGGER.debug("Received request to delete user with Id : {} ", id);
		userService.delete(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUsers() {
		LOGGER.debug("Received request to list all users");
		return userService.getList();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") String id) {
		LOGGER.debug("Received request to get the user with id {} ",id);
		return userService.findUser(id);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
		return e.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleUserNotFoundException(UserNotFoundException e) {
		return e.getMessage();
	}

}
