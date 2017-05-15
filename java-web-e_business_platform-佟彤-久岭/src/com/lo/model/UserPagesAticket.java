package com.lo.model;

import java.util.List;

import com.lo.entity.AdminTicket;
import com.lo.entity.Pages;

public class UserPagesAticket {

	private Pages pages;
	private List<AdminTicket> la;
	public Pages getPages() {
		return pages;
	}
	public void setPages(Pages pages) {
		this.pages = pages;
	}
	public List<AdminTicket> getLa() {
		return la;
	}
	public void setLa(List<AdminTicket> la) {
		this.la = la;
	}
	
}
