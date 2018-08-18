package com.comercial.service;

import java.util.List;

import com.comercial.model.User;

public interface UserService {
	
	
	public List<User> getAllUser();
	
	
	public User loginUser(User user);
	

}
