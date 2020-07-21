package com.elegant.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elegant.spring.dao.UserDao;
import com.elegant.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}

	public User findByUsername(String username) {
		return userDao.getByUsername(username);
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
