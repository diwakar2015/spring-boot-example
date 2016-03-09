package com.diwakar.springboot.example.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.diwakar.springboot.example.domain.User;
import com.diwakar.springboot.example.exception.UserAlreadyExistsException;
import com.diwakar.springboot.example.exception.UserNotFoundException;
import com.diwakar.springboot.example.repository.UserRepository;

/*
 *@author Diwakar Choudhary
 *Date: 10-March-2016
 */


@Service
@Validated
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	@Inject
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public User save(@NotNull @Valid final User user) {
		LOGGER.debug("Creating {}", user);
		User existing = userRepository.findOne(user.getId());
		if (existing != null) {
			throw new UserAlreadyExistsException(
					String.format("There already exists a user with id=%s", user.getId()));
		}
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getList() {
		LOGGER.debug("Retrieving the list of all users");
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(String id) {
		LOGGER.debug("Fetching the user details for id : {} ", id);
		User user = userRepository.findById(id);
		if(user==null)
			throw new UserNotFoundException(String.format("There is no user found with id = %s", id));
		return user;
	}

	@Override
	@Transactional
	public User update(User user) {
		LOGGER.debug("Updating the user details for id : {} ", user.getId());

		User fetchedUser = userRepository.findById(user.getId());
		if(fetchedUser==null)
			throw new UserNotFoundException(String.format("There is no user found with id = %s", user.getId()));

		User updatedUser = userRepository.save(user);

		return updatedUser;
	}

	@Override
	@Transactional
	public void delete(String id) {
		LOGGER.debug("Deleting the user details for id : {} ", id);

		User fetchedUser = userRepository.findById(id);
		if(fetchedUser==null)
			throw new UserNotFoundException(String.format("There is no user found with id = %s", id));

		userRepository.delete(id);

	}

	@Override
	@Transactional
	public void deleteAll() {
		LOGGER.debug("Deleting the all the users");
		userRepository.deleteAll();
	}

}
