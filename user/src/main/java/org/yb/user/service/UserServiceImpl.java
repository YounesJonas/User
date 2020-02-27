package org.yb.user.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yb.user.dao.UserDAO;
import org.yb.user.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Optional<User>  displayDetailsUser(String id) {
		
		// find user by id
		return userDao.findById(id);
	
	}
	

	
}
