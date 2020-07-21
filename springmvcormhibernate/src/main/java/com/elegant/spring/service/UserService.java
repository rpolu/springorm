package com.elegant.spring.service;

import java.util.List;

import com.elegant.spring.model.User;

 

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List <User>  getUserList();
}
