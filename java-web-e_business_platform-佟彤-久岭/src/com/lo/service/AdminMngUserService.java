package com.lo.service;

import java.util.List;
import java.util.Map;

import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.User;
import com.lo.model.AdminCkeckUserForField;

public interface AdminMngUserService {

	public List<User> findUsers();
	
	public void stopUserTo0(int uid);
	
	public void openUserTo1(int uid);
	
	public List<User> checkUserForTime(AdminForTimeCheck adminForTimeCheck);
	
	public List<User> checkseeUserForField(User user);
	
	public int findUserCount();
	
	public List<User> findUsers_limit(Map<String, Object> map);
	
	public int findUserCountForTime(AdminForTimeCheck adminForTimeCheck);
	
	public List<User> findUsersForTime_limit(Map<String, Object> map);

	public int findUserCountForField(AdminCkeckUserForField adminCkeckUserForField);
	
	public List<User> findUsersForField_limit(Map<String, Object> map);

}
