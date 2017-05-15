package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.AdminDao;
import com.lanou.entity.Admin;
import com.lanou.entity.Item;
import com.lanou.entity.User;
import com.lanou.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	private AdminDao adminDao;
	
	@Override
	public List<User> findUser(){
		List<User>  lu=adminDao.findUser();
		return lu;
	}
	@Override
	public void saveadd(Item item) {
		adminDao.saveadd(item);
		
	}
	
	@Override
	public void saveItem(Item item) {
		adminDao.saveItem(item);
		
	}
	
	@Override
	public void deleteItem(int a) {
		adminDao.deleteItem(a);
		
	}
//	public void updateItem(int a) {
//		adminDao.updateItem(a);
//		
//	}

	
	@Override
	public List<Admin> findAdmin() {
		List<Admin> la = adminDao.findAdmin();
		return la;
		
	}
	@Override
	public List<Item> findItem() {
		List<Item> li= adminDao.findItem();
		return li;
		
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	
}
