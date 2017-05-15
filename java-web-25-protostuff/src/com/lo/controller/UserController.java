package com.lo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lo.cache.ProductRedisDao;
import com.lo.entity.User;
import com.lo.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private ProductRedisDao prd;
	
	@RequestMapping("findUser")
	@ResponseBody
	public User findUser(@RequestBody User user){
		int id = user.getId();
		User uu = prd.getproduct(id);
		System.out.println(uu.getUserName());
		if(uu != null){
			return uu;
		}else{
		User u = userService.findUser(user.getId());
		prd.saveProduct(u);
		return u;
	}
}
}
