package com.lanou.admin.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.lanou.entity.Admin;
import com.lanou.entity.Item;
import com.lanou.entity.User;
import com.lanou.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private Admin admin;
	private Item item;
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	public String findUser(){
		HttpServletRequest req = ServletActionContext.getRequest();
		List<User> lu = adminService.findUser();
		req.setAttribute("user", lu);
		return "user";
		
	}
	public String loginin(){
		return "loginin";
	}
	public String saveadd(){
		adminService.saveadd(item);
		return "saveadd";
	}
	public String addItem(){
		return "addItem";
	}
	public String saveItem(){
		HttpServletRequest req = ServletActionContext.getRequest();
		List<Item> li = adminService.findItem();
		req.setAttribute("list", li);
		adminService.saveItem(item);
		return "saveItem";
	}
	public String out(){
		session.clear();
		return "out";
		
	}
	public String login() {

		List<Admin> la = adminService.findAdmin();
		for (Admin ad : la) {
			if (admin.getAdminName().equals(ad.getAdminName()) 
					&& admin.getAdminPwd().equals(ad.getAdminPwd())) {
				HttpServletRequest req = ServletActionContext.getRequest();
				HttpSession session = req.getSession();
				session.setAttribute("name", admin.getAdminName());
				return "index";
			}
		}
		return "login";
	}

	public String deleteItem() {
		adminService.deleteItem(item.getId());

		return "deleteItem";
	}

	public String updateItem() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		List<Item> li = adminService.findItem();
		session.setAttribute("list", li);
		return "updateItem";
	}

	public String indexlogin() {
		return "indexlogin";
	}

	public String findItem() {
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		List<Item> li = adminService.findItem();
		session.setAttribute("list", li);

		return "findItem";
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	

}
