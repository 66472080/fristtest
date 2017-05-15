package com.lo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminOrderModel;
import com.lo.entity.AdminPage;
import com.lo.model.AdminCheckOrders;
import com.lo.service.AdminOrderModelService;

@Controller
public class AdminOrderController {

	@Resource
	private AdminOrderModelService adminOrderModelService;
	
	@RequestMapping("/findOrders_limit")
	@ResponseBody
	public AdminCheckOrders findOrders_limit(@RequestBody int currentPage){	
		
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(currentPage);
		int totalOrder = adminOrderModelService.findOrderCount();
		adminPage.setTotalNumber(totalOrder);
		
		
		List<AdminOrderModel> adminOrderModel = adminOrderModelService.findOrders_limit(adminPage);
		AdminCheckOrders orders = new AdminCheckOrders();
		orders.setAdminPage(adminPage);
		orders.setAdminOrderModel(adminOrderModel);
		
		return orders;//checkOrderForTime_limit
	}
	
	@RequestMapping("/checkOrderForTime_limit")
	@ResponseBody
	public AdminCheckOrders checkOrderForTime_limit(@RequestBody AdminForTimeCheck adminForTimeCheck){	
		
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(adminForTimeCheck.getInitPage());
		int totalOrder = adminOrderModelService.findOrderCountForTime(adminForTimeCheck);
		adminPage.setTotalNumber(totalOrder);
		
		Map<String,Object> map = new HashMap<>();
		map.put("adminPage", adminPage);
		map.put("adminForTimeCheck", adminForTimeCheck);
		List<AdminOrderModel> adminOrderModels = adminOrderModelService.findOrdersForTime_limit(map);
		
		AdminCheckOrders adminCheckOrders = new AdminCheckOrders();
		adminCheckOrders.setAdminOrderModel(adminOrderModels);
		adminCheckOrders.setAdminPage(adminPage);
		
		return adminCheckOrders;//adminForTimeCheck
	}
	
	@RequestMapping("/checkseeOrderForField_limit")
	@ResponseBody
	public AdminCheckOrders checkseeOrderForField_limit(@RequestBody AdminOrderModel adminOrderModel){	
		
		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(adminOrderModel.getCurrent());
		int totalNumber = adminOrderModelService.findOrdersCountForField_limit(adminOrderModel);
		adminPage.setTotalNumber(totalNumber);
		
		Map<String,Object> map = new HashMap<>();
		map.put("adminPage", adminPage);
		map.put("adminOrderModel", adminOrderModel);
		List<AdminOrderModel> adminOrderModels = adminOrderModelService.findOrdersForField_limit(map);
		
		AdminCheckOrders adminCheckOrders = new AdminCheckOrders();
		adminCheckOrders.setAdminOrderModel(adminOrderModels);
		adminCheckOrders.setAdminPage(adminPage);
		
		
		return adminCheckOrders;//adminForTimeCheck
	}
	
}
