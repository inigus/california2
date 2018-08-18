package com.comercial.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comercial.model.User;

public class UserServiceImpl implements UserService {
	
	
	//@Inject

	
	
	public List<User> getAllUser() {
		
		
		List<User> users = new ArrayList<>();
		
		return users;
		
	}

	@Override
	public User loginUser(User user) {
		
		
		user.setLastAccess(new Date() );
		
		return user;
	}
	

	
	
}
