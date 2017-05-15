package com.lo.entity;

public class AdminPage {


	//������
	private int totalNumber;
	//��ǰ�ڼ�ҳ
	private int currentPage;
	//��ҳ��
	private int totalPage;
	//ÿҳ��ʾ����-
	private int pageNumber = 7;
	//���ݿ���limit�Ĳ���,�ӵڼ�����ʼȡ
	private int dbIndex;
	//���ݿ���limit�Ĳ���,һ��ȡ������
	private int dbNumber;
	
	//���ݵ�ǰ����������ֵ���Ҽ�����ص�����
	public void count(){
		//������ҳ��
		if (this.totalNumber % this.pageNumber == 0){
			this.totalPage = this.totalNumber / this.pageNumber; 
		} else {
			this.totalPage = this.totalNumber / this.pageNumber + 1;
		}
		//�����ǰҳС��1������Ϊ1
		if(this.currentPage < 1){
			this.currentPage = 1;
		}
		if(this.currentPage > this.totalPage){
			this.currentPage = this.totalPage ;
		}
		//����limit����
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	
	public int getTotalNumber() {
		return totalNumber;
	}
	/**
	 * set����
	 * @param totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();//ִ��count����
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
