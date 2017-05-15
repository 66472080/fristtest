package com.lo.service;

import java.util.List;
import java.util.Map;

import com.lo.entity.AdminTicket;
import com.lo.entity.Order;
import com.lo.entity.Pages;
import com.lo.entity.SC;
import com.lo.entity.User;

public interface UserService {

	public List<User> findUser();
	public User findUser2(int id);
	public void updateUser(User user);
	public void updateUser2(User user);
	public void saveUser(User user);
	public List<AdminTicket> findTicket();
	public List<AdminTicket> findTicket2(AdminTicket at);
	public List<SC> findSC(int uid);
	public void saveSC(SC ss);
	public List<AdminTicket> findTicket3(AdminTicket at);
	public void deleteSC(int lid);
	public void deleteSC2(int uid);
	public void updateUser3(User u );
	public void updateat(AdminTicket at);
	public void saveOrder(Order o);
	public List<Order> findbill();
	
	public Order findOrders(Order o);
	public int findbillsCount(int a);
	public List<Order> findOrdersbills(Map<String, Object> pageMap);
	public int findTicket4();
	public List<AdminTicket> findTicket8(Pages p);
}
