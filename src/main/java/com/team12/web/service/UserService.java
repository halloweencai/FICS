package com.team12.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.team12.web.dao.UserDAO;
import com.team12.web.model.User;

@Service
public class UserService {
	
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource
	public void setUserDAO(UserDAO userDao) {
		this.userDAO = userDao;
	}

	public void add(User u) {
		this.userDAO.save(u);
	}
	
	public List<User> getAllUser() {
        List<User> tuList = userDAO.findAll();
        return tuList;
    }

	public User find(int numericId) {
		return userDAO.findById(numericId);
	}

	public List<User> findByUsername(String account) {
		return userDAO.findByUsername(account);
	}


}
