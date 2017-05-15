package com.lo.model;

import java.util.List;

import com.lo.entity.Order;
import com.lo.entity.Pages;

public class PageModel {

	private Pages pages;
	private List<Order> o1;
	public Pages getPages() {
		return pages;
	}
	public void setPages(Pages pages) {
		this.pages = pages;
	}
	public List<Order> getO1() {
		return o1;
	}
	public void setO1(List<Order> o1) {
		this.o1 = o1;
	}
	
}
