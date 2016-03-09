package com.diwakar.springboot.example.repository;

/*
 *@author Diwakar Choudhary
 *Date: 10-March-2016
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.diwakar.springboot.example.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	User findById(String id);
	
}
