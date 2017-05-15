package com.lo.entity;

public class AdminForTimeCheck {

	private String check_time;
	private String start_time;
	private String end_time;
	private int initPage ;

	public int getInitPage() {
		return initPage;
	}

	public void setInitPage(int initPage) {
		this.initPage = initPage;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCheck_time() {
		return check_time;
	}

	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}

}
