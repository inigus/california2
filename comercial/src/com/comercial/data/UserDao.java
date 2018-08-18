package com.comercial.data;

import java.util.List;

import com.comercial.model.User;

public interface UserDao {


	public User getUser(String nameUser, String password);

	public boolean insertUser(User user);

	public boolean deleteUser(User user);
	
	public List<User> getAllUser();

}
