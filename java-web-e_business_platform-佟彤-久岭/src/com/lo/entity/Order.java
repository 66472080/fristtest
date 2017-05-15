package com.lo.entity;

import java.sql.Timestamp;

public class Order {

	private int oid;
	private Timestamp commitTime;
	private double amount;
	private String dese;
	private int lid;
	private int xuhao;
	private int uid;
	private double price;
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public Timestamp getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Timestamp commitTime) {
		this.commitTime = commitTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDese() {
		return dese;
	}
	public void setDese(String dese) {
		this.dese = dese;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	
}
