package com.lo.model;

import java.util.List;

import com.lo.entity.AdminOrderModel;
import com.lo.entity.AdminPage;

public class AdminCheckOrders {

	private List<AdminOrderModel> adminOrderModel;
	private AdminPage adminPage;


	public List<AdminOrderModel> getAdminOrderModel() {
		return adminOrderModel;
	}

	public void setAdminOrderModel(List<AdminOrderModel> adminOrderModel) {
		this.adminOrderModel = adminOrderModel;
	}

	public AdminPage getAdminPage() {
		return adminPage;
	}

	public void setAdminPage(AdminPage adminPage) {
		this.adminPage = adminPage;
	}

}
