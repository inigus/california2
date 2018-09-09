package com.comercial.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comercial.data.UserDao;
import com.comercial.data.UserDaoImpl;
import com.comercial.data.VisitDao;
import com.comercial.data.VisitDaoImpl;
import com.comercial.model.User;

public class UserServiceImpl extends BaseService  implements UserService {
	
	
	private UserDao userDao = new UserDaoImpl(this.em);

	
	
	public List<User> getAllUser() {
		
		
		List<User> users = new ArrayList<>();
		
		return users;
		
	}

	@Override
	public User loginUser(User user) {
		
		User userValidated = userDao.getUser(user.getMail(), user.getPassword());
		
		return userValidated;
	}
	

	
	
}
