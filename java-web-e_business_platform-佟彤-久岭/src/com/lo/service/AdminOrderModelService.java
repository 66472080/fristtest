package com.lo.service;

import java.util.List;
import java.util.Map;

import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminOrderModel;
import com.lo.entity.AdminPage;

public interface AdminOrderModelService {

	public List<AdminOrderModel> findOrders(AdminPage adminPage);
	
	public List<AdminOrderModel> findOrders_limit(AdminPage adminPage);
	
	public List<AdminOrderModel> findOrders();

	public List<AdminOrderModel> checkOrderForTime(AdminForTimeCheck AdminForTimeCheck);

	public List<AdminOrderModel> checkseeOrderForField(AdminOrderModel AdminForTimeCheck);

	public int findOrderCount();
	
	public int findOrderCountForTime(AdminForTimeCheck adminForTimeCheck);
	
	public List<AdminOrderModel> findOrdersForTime_limit(Map<String, Object> map);
	
	public int findOrdersCountForField_limit(AdminOrderModel adminOrderModel);

	public List<AdminOrderModel> findOrdersForField_limit(Map<String, Object> map);


}
