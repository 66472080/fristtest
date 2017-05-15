package com.lo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lo.dao.UserDao;
import com.lo.entity.User;
import com.lo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findUser(int id) {
		return userDao.findUser(id);
	}

}
