package com.comercial.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.comercial.model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	
	public UserDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public User getUser(String nameUser, String password) {

		try {
			User user = (User) em
					.createQuery(
							"SELECT u from User u where u.nameUser = :name and u.password = :password")
					.setParameter("name", nameUser)
					.setParameter("password", password).getSingleResult();

			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public boolean insertUser(User user) {
		try {
			em.persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			em.remove(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<User> getAllUser() {

		try {
			
			
			List<User> users = (List<User>) em
					.createQuery("SELECT u from User u")
					.getResultList();
			return users;
		} catch (NoResultException e) {
			return null;
		}
	}

}
