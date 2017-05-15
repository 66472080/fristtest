package com.lo.entity;

import java.sql.Timestamp;

public class User {

	private int uid;
	private String age;	
	private	String userName;
	private String userPwd;
	private String name;
	private String gender;
	private String idCard;
	private String address;
	private String telon ;
	private Timestamp regTime;
	private Double balance;
	private int status;
	
	
	

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelon() {
		return telon;
	}
	public void setTelon(String telon) {
		this.telon = telon;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}