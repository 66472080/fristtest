package com.lo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lo.dao.AdminOrderModelDao;
import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminOrderModel;
import com.lo.entity.AdminPage;
import com.lo.service.AdminOrderModelService;

@Service
public class AdminOrderModelServiceImpl implements AdminOrderModelService {

	@Resource
	private AdminOrderModelDao adminOrderModelDao;

	@Override
	public List<AdminOrderModel> findOrders() {
		return adminOrderModelDao.findOrders();
	}

	@Override
	public List<AdminOrderModel> checkOrderForTime(AdminForTimeCheck AdminForTimeCheck) {
		return adminOrderModelDao.checkOrderForTime(AdminForTimeCheck);
	}

	@Override
	public List<AdminOrderModel> checkseeOrderForField(AdminOrderModel AdminForTimeCheck) {
		return adminOrderModelDao.checkseeOrderForField(AdminForTimeCheck);
	}

	@Override
	public List<AdminOrderModel> findOrdersForTime_limit(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adminOrderModelDao.findOrdersForTime_limit(map);
	}

	@Override
	public int findOrderCountForTime(AdminForTimeCheck adminForTimeCheck) {
		// TODO Auto-generated method stub
		return adminOrderModelDao.findOrderCountForTime(adminForTimeCheck);
	}

	@Override
	public int findOrderCount() {

		return adminOrderModelDao.findOrderCount();
	}
@Override
public List<AdminOrderModel> findOrdersForField_limit(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return adminOrderModelDao.findOrdersForField_limit(map);
}
	@Override
	public int findOrdersCountForField_limit(AdminOrderModel adminOrderModel) {
		// TODO Auto-generated method stub
		return adminOrderModelDao.findOrdersCountForField_limit(adminOrderModel);
	}

	@Override
	public List<AdminOrderModel> findOrders_limit(AdminPage adminPage) {
		// TODO Auto-generated method stub
		return adminOrderModelDao.findOrders_limit(adminPage);
	}

	@Override
	public List<AdminOrderModel> findOrders(AdminPage adminPage) {

		return adminOrderModelDao.findOrders(adminPage);
	}

}
