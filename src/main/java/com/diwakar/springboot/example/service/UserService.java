package com.diwakar.springboot.example.service;

import java.util.List;

import com.diwakar.springboot.example.domain.User;

/*
 *@author Diwakar Choudhary
 *Date: 10-March-2016
 */


public interface UserService {

    User save(User user);
    
    List<User> getList();
    User findUser(String id);
    
    User update(User user);
    
    void delete(String id);
    void deleteAll();

}
