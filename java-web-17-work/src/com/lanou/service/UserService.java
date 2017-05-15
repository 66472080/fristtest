package com.lanou.service;

import java.util.List;

import com.lanou.entity.User;

public interface UserService {

	public void saveUser(User user);

	public List<User> findUser();

	void deleteUser(int id);

	void updateUser(User user);

}
