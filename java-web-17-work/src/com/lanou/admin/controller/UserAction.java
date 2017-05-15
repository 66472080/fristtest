package com.lanou.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware {
	
  private UserService userService;
  private User user;
  Map<String, Object> session;
  
	@Override
	public void setSession(Map<String, Object> session) {

		this.session=session;	
	}
	
	public String loginnn(){
		return "loginnn";
	}
	
	
	
	
//	登陆判断
	public String  login(){
		List<User> list = userService.findUser();
		for (User u : list) {
			if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())){
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("uid", u.getUid());
				session.setAttribute("username", u.getUsername());
				session.setAttribute("password", u.getPassword());
				session.setAttribute("name", u.getName());
				session.setAttribute("idnumber", u.getIdnumber());
				session.setAttribute("telno", u.getTelno());
				return "index";//成功返回 成功页面
			}
		}	
		return "register";//失败返回 注册页面
	}
//	注册
	public String register(){
		    userService.saveUser(user);	
			return "login";//注册成功返回登陆界面
	}
//	个人信息
	public String personal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return "personal";	
	}
// 修改个人信息
	public String update(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid=(int) session.getAttribute("uid");
		if(user.getIdnumber()!=null && user.getName()!=null &&user.getPassword()!=null && user.getTelno()!=null){
			user.setUid(uid);
		    userService.updateUser(user);
		    return "update";
		}
		return "update";
	}
//	主页面
	public String index(){
		return "index";
	}
//	考试页面
//	public String exam(){
//		return "exam";
//	}
//	考试记录
	public String examlog(){
		return "examlog";
	}

//  退出
	public String d(){
		session.clear();
		return "login";
	}
	


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	
}
