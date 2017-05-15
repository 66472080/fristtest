package com.lo.model;

import java.util.List;

import com.lo.entity.AdminPage;
import com.lo.entity.AdminTicket;

public class AdminFindTicketsForLimitModel {

	private List<AdminTicket> adminTicket;
	private AdminPage adminPage;

	public List<AdminTicket> getAdminTicket() {
		return adminTicket;
	}

	public AdminPage getAdminPage() {
		return adminPage;
	}

	public void setAdminPage(AdminPage adminPage) {
		this.adminPage = adminPage;
	}

	public void setAdminTicket(List<AdminTicket> adminTicket) {
		this.adminTicket = adminTicket;
	}

	

}
