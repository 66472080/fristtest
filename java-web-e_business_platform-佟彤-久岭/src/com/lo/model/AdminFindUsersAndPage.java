package com.lo.model;

import java.util.List;

import com.lo.entity.AdminPage;
import com.lo.entity.User;

public class AdminFindUsersAndPage {

	private AdminPage adminPage;
	private List<User> user;

	public AdminPage getAdminPage() {
		return adminPage;
	}

	public void setAdminPage(AdminPage adminPage) {
		this.adminPage = adminPage;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
