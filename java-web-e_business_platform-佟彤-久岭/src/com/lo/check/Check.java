package com.lo.check;

import org.springframework.stereotype.Component;

@Component
public class Check {

	public boolean checkname(String name){
		String cname="^[\u0391-\uFFE5]+$ ";
		if(name.matches(cname)){
			return true;
		}
		
		return false;
		
	}
	
	//用户名检查
	public boolean checkuserName(String userName){
		String cuserName="^[A-Za-z][A-Za-z0-9_-]+$";
		if(userName.matches(cuserName)){
			return true;
		}
		
		return false;
		
	}
	public boolean checktelon(String telon){
		String ctelon="^1[3|4|5|8][0-9]\\d{8}$";
		if(telon.matches(ctelon)){
			return true;
		}		
		return false;
		
	}
}
