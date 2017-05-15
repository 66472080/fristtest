package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.UserDao;
import com.lanou.entity.User;
import com.lanou.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);	
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public List<User> findUser() {
		List<User> list = userDao.findUser();
		return list;	
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
