package com.elegant.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elegant.spring.model.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;


	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getSession().createQuery("from User").list();
	}

	public User getByEmail(String email) {
		return (User) getSession().createQuery("from User where email = :email").setParameter("email", email)
				.uniqueResult();
	}

	public User getByUsername(String username) {
		return (User) getSession().createQuery("from User where username = :username")
				.setParameter("username", username).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		return getSession().createCriteria(User.class).list();
	}

}