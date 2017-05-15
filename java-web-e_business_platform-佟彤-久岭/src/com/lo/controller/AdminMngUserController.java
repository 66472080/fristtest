package com.lo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminPage;
import com.lo.entity.User;
import com.lo.model.AdminCkeckUserForField;
import com.lo.model.AdminFindUsersAndPage;
import com.lo.service.AdminMngUserService;

@Controller
public class AdminMngUserController {

	@Resource
	private AdminMngUserService adminMngUserService;
	
	@RequestMapping("/findUsers_limit")
	@ResponseBody
	public AdminFindUsersAndPage findUsers_limit(@RequestBody int initPage){
		
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(initPage);
		//查询总的用户数
		int userCount = adminMngUserService.findUserCount();
		adminPage.setTotalNumber(userCount);
		
		User user = new User();
		Map<String, Object> map = new HashMap<>();
		map.put("adminPage", adminPage);
		map.put("user", user);
		List<User> users = adminMngUserService.findUsers_limit(map);
		
		AdminFindUsersAndPage adminFindUsersAndPage = new AdminFindUsersAndPage();
		adminFindUsersAndPage.setAdminPage(adminPage);
		adminFindUsersAndPage.setUser(users);
		return adminFindUsersAndPage;//checkseeUserForField
	}//checkUserForTime_limit
	
	@RequestMapping("/checkUserForTime_limit")
	@ResponseBody
	public AdminFindUsersAndPage checkUserForTime_limit(@RequestBody AdminForTimeCheck adminForTimeCheck){
		
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(adminForTimeCheck.getInitPage());
		//查询总的用户数
		int userCount = adminMngUserService.findUserCountForTime(adminForTimeCheck);
		adminPage.setTotalNumber(userCount);
		
		User user = new User();
		Map<String, Object> map = new HashMap<>();
		map.put("adminPage", adminPage);
		map.put("user", user);
		map.put("adminForTimeCheck", adminForTimeCheck);
		List<User> users = adminMngUserService.findUsersForTime_limit(map);
		
		AdminFindUsersAndPage adminFindUsersAndPage = new AdminFindUsersAndPage();
		adminFindUsersAndPage.setAdminPage(adminPage);
		adminFindUsersAndPage.setUser(users);
		return adminFindUsersAndPage;//checkseeUserForField
	}//checkUserForTime_limit
	
	
	
	@RequestMapping("/checkseeUserForField_limit")
	@ResponseBody
	public AdminFindUsersAndPage checkseeUserForField(@RequestBody AdminCkeckUserForField adminCkeckUserForField){
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(adminCkeckUserForField.getCurrent());
		int userCount = adminMngUserService.findUserCountForField(adminCkeckUserForField);
		adminPage.setTotalNumber(userCount);
		
		User user = new User();
		Map<String, Object> map = new HashMap<>();
		map.put("adminPage", adminPage);
		map.put("user", user);
		map.put("adminCkeckUserForField", adminCkeckUserForField);
		
		List<User> users = adminMngUserService.findUsersForField_limit(map);
		AdminFindUsersAndPage adminFindUsersAndPage = new AdminFindUsersAndPage();
		adminFindUsersAndPage.setAdminPage(adminPage);
		adminFindUsersAndPage.setUser(users);
		return adminFindUsersAndPage;		
	}
	
	@RequestMapping("/checkUserForTime")
	@ResponseBody
	public List<User> checkUserForTime(@RequestBody AdminForTimeCheck adminForTimeCheck){
		return adminMngUserService.checkUserForTime(adminForTimeCheck);		
	}
	
	
	@RequestMapping("/stopUser")
	@ResponseBody
	public String stopUserTo0(@RequestBody int uid){
		adminMngUserService.stopUserTo0(uid); ;//check_openUser
		return "adminUserMng";
	}
	
	@RequestMapping("/openUser")
	@ResponseBody
	public String openUserTo1(@RequestBody int uid){
		System.out.println(uid);
		adminMngUserService.openUserTo1(uid); ;//stopUser
		return "adminUserMng";
	}
	
	@RequestMapping("views/check_openUser")
	public String check_stopUserTo0(int uid){
		adminMngUserService.stopUserTo0(uid); ;//check_openUser
		return "adminUserMng";
	}
	
	@RequestMapping("views/check_stopUser")
	public String check_openUserTo1(int uid){
		System.out.println(uid);
		adminMngUserService.openUserTo1(uid); ;//stopUser
		return "adminUserMng";
	}
}
