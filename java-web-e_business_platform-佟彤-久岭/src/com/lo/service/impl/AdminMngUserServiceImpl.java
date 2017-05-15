package com.lo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lo.dao.AdminMngUserDao;
import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.User;
import com.lo.model.AdminCkeckUserForField;
import com.lo.service.AdminMngUserService;

@Service
public class AdminMngUserServiceImpl implements AdminMngUserService{

	@Resource
	private AdminMngUserDao adminMngUserDao ;
	
	
	@Override
	public List<User> findUsers() {
		return adminMngUserDao.findUsers();
	}


	@Override
	public void stopUserTo0(int uid) {
		adminMngUserDao.stopUserTo0(uid);
		
	}


	@Override
	public void openUserTo1(int uid) {
		adminMngUserDao.openUserTo1(uid);
		
	}

	@Override
	public List<User> findUsersForField_limit(Map<String, Object> map) {
		
		return adminMngUserDao.findUsersForField_limit(map);
	}

	@Override
	public List<User> checkUserForTime(AdminForTimeCheck adminForTimeCheck) {
		
		return adminMngUserDao.checkUserForTime(adminForTimeCheck);
	}


	@Override
	public List<User> checkseeUserForField(User user) {
		return adminMngUserDao.checkseeUserForField(user);
	}


	@Override
	public int findUserCount() {
		return adminMngUserDao.findUserCount();
	}

	@Override
	public List<User> findUsers_limit(Map<String, Object> map) {
		
		return adminMngUserDao.findUsers_limit(map);
	}


	@Override
	public int findUserCountForTime(AdminForTimeCheck adminForTimeCheck) {
		return adminMngUserDao.findUserCountForTime(adminForTimeCheck);
	}

	
	@Override
	public List<User> findUsersForTime_limit(Map<String, Object> map) {
		return adminMngUserDao.findUsersForTime_limit(map);
	}

	@Override
	public int findUserCountForField(AdminCkeckUserForField adminCkeckUserForField) {
		// TODO Auto-generated method stub
		return adminMngUserDao.findUserCountForField(adminCkeckUserForField);
	}
	










}
