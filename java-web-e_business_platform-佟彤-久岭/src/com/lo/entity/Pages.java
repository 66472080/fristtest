package com.lo.entity;

public class Pages {

	//总条数
	private int totalNumber;
	//当前页
	private int currentPage;
	//总页数
	private int totalPage;
	//每页显示条数
	private int pageNumber = 5;
	//数据库中limit的参数,从第几条开始取
	private int dbIndex;
	//数据库中limit的参数 一共取多少条
	private int dbNumber;
	
	
	//计算总页数的方法
	public void count(){
		//拿到总数据条数 用总数据条数判断
		//判断数据条数显示需要的页数
		if(this.totalNumber%this.pageNumber == 0){
			//总页数就等于数据总条数 除以 每页显示数量
			this.totalPage=this.totalNumber/this.pageNumber;
		}else{
			//总页数就等于数据总条数 除以 每页显示数量 +1
			this.totalPage=this.totalNumber/this.pageNumber + 1;
		}
		//如果传过来的值小于1  甚至是负数 也都从第一页开始查询
		if(this.currentPage<1){
			this.currentPage=1;
		}
		//数据库中查询字段所需要的值 limit  x,y;
		this.dbNumber=this.pageNumber;
		this.dbIndex=(this.currentPage-1)*this.dbNumber;
		
	}
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();//执行count方法
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNumber() {
		return dbNumber;
	}
	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
	
}
