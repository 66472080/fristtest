package com.lo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lo.controller.UserController;
import com.lo.dao.UserDao;
import com.lo.entity.AdminTicket;
import com.lo.entity.Order;
import com.lo.entity.Pages;
import com.lo.entity.SC;
import com.lo.entity.User;
import com.lo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Resource
	private UserController userController;
	public List<User> findUser(){
		return userDao.findUser();
	}
	public User findUser2(int id){
		return userDao.findUser2(id);
	}
	public void saveUser(User user){
		if (user.getUserName() != "" && user.getUserPwd() != "") {
			userDao.saveUser(user);
			
		}else{
			userController.saveUser(user);
		}
		
	}
	public List<AdminTicket> findTicket(){
		return userDao.findTicket();
	}
	public List<AdminTicket> findTicket2(AdminTicket at){
		return userDao.findTicket2(at);
	}
	public List<SC> findSC(int uid){
		return userDao.findSC(uid);
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
	@Override
	public void updateUser2(User user) {
		userDao.updateUser2(user);
		
	}
	@Override
	public void saveSC(SC ss) {
		userDao.saveSC(ss);
		
	}
	@Override
	public List<AdminTicket> findTicket3(AdminTicket at) {
		return userDao.findTicket3(at);
	}
	@Override
	public void deleteSC(int lid) {
		userDao.deleteSC(lid);
		
	}
	@Override
	public void deleteSC2(int uid) {
		userDao.deleteSC2(uid);
		
	}
	@Override
	public void updateUser3(User u) {
		userDao.updateUser3(u);
		
	}
	@Override
	public void updateat(AdminTicket at) {
		userDao.updateat(at);
		
	}
	@Override
	public void saveOrder(Order o) {
		userDao.saveOrder(o);
		
	}
	@Override
	public List<Order> findbill() {
		
		return userDao.findbill();
	}
	@Override
	public Order findOrders(Order o) {
		return userDao.findOrders(o);
	}
	@Override
	public int findbillsCount(int a) {
		
		return userDao.findbillsCount(a);
	}
	@Override
	public List<Order> findOrdersbills(Map<String, Object> pageMap) {
		return userDao.findOrdersbills( pageMap);
	}
	@Override
	public int findTicket4() {
		
		return userDao.findTicket4();
	}
	@Override
	public List<AdminTicket> findTicket8(Pages p) {
		return userDao.findTicket8(p);
	}
	
	
}
