package com.lanou.service;

import java.util.List;

import com.lanou.entity.Admin;
import com.lanou.entity.Item;
import com.lanou.entity.User;

public interface AdminService {
	public List<Admin> findAdmin();
	public void deleteItem(int a);
	//public void updateItem(int i);
	public List<Item> findItem();
	public void saveItem(Item item);
	public void saveadd(Item item);
	public List<User> findUser();
	
}
