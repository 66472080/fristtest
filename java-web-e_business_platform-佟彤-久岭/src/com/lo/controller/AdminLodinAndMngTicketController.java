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
import com.lo.entity.AdminPage;
import com.lo.entity.AdminTicket;
import com.lo.entity.AdminUser;
import com.lo.model.AdminFindTicketsForLimitModel;
import com.lo.service.AdminService;

@Controller
public class AdminLodinAndMngTicketController {

	@Resource
	private AdminService adminService;// adminAddTicket

	@RequestMapping("/begin")
	public String begin() {
		return "adminLogin";
	}

	@RequestMapping("/adminExit")
	public String adminExit() {

		return "adminLogin";
	}

	/**
	 * ��ѯƱ������--��ҳ
	 * @param tid
	 * @return
	 */
	@RequestMapping("/findTickets_limit")
	@ResponseBody
	public AdminFindTicketsForLimitModel findTickets_limit(@RequestBody int currentPage) {

		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(currentPage);
		//��ѯ����
		int ticketCount = adminService.findTicketCount();
		adminPage.setTotalNumber(ticketCount);
		

		AdminTicket adminTicket = new AdminTicket();
		Map<String, Object> tickets = new HashMap<>();
		tickets.put("adminPage", adminPage);
		tickets.put("adminTicket", adminTicket);
		List<AdminTicket> findTicket_limit = adminService.findTickets_limit(tickets);
		
		AdminFindTicketsForLimitModel adminFindTicketsForLimitModel = new AdminFindTicketsForLimitModel();
		adminFindTicketsForLimitModel.setAdminPage(adminPage);
		adminFindTicketsForLimitModel.setAdminTicket(findTicket_limit);
		return adminFindTicketsForLimitModel;
	}
	
	
	@RequestMapping("/begin_Sall")
	@ResponseBody
	public String beginSall(@RequestBody int tid) {
		adminService.updateStatusTo1(tid);
		return "adminTicketMng";
	}

	@RequestMapping("/stop_Sall")
	@ResponseBody
	public String stop(@RequestBody int tid ) {
		adminService.updateStatusToO(tid);		
		return "adminTicketMng";
	}//admin_updateTicket
	
	@RequestMapping("/adminupdateTicket")
	@ResponseBody
	public String admin_updateTicket(@RequestBody AdminTicket adminTicke){				
		adminService.updateTickets(adminTicke);
		return "ok" ;
	}
	
	
	@RequestMapping("/updateTicket")
	@ResponseBody
	public List<AdminTicket> updateTicket(@RequestBody AdminTicket adminTicket){		
		List<AdminTicket> list = adminService.findTickets(adminTicket);
		return list ;
	}
	

	@RequestMapping(value = "/admin_AddTicket")
	@ResponseBody
	public String adminAddTicket(@RequestBody AdminTicket adminTicket) {
		adminTicket.setBalance(adminTicket.getAmount());
		adminService.adminAddTicket(adminTicket);
		return "adminTicketMng";
	}

	@RequestMapping("/adminLogin")
	@ResponseBody
	public String adminLogin(@RequestBody AdminUser adminUser) {
		List<AdminUser> list = adminService.findAdminUsers();
		for (AdminUser user : list) {
			if (adminUser.getUserName().equals(user.getUserName())
					&& adminUser.getPassword().equals(user.getPassword())) {
				return "yes";
			}
		}
		return "no";
	}

	@RequestMapping("/admin_seeTicket_limit")//admin_seeTicket_limit_current
	@ResponseBody
	public AdminFindTicketsForLimitModel admin_seeTicket_limit(@RequestBody AdminForTimeCheck adminSeeTicketTime) {

		AdminPage adminPage = new AdminPage();
		adminPage.setCurrentPage(adminSeeTicketTime.getInitPage());
		int countTicketForTime = adminService.findTicketCountForTime(adminSeeTicketTime);
		adminPage.setTotalNumber(countTicketForTime);
		
		AdminTicket adminTicket = new AdminTicket();
		Map<String,Object> xx = new HashMap<>();
		xx.put("adminSeeTicketTime", adminSeeTicketTime);
		xx.put("page", adminPage);
		xx.put("adminTicket", adminTicket);
		List<AdminTicket> list = adminService.findTicketForTime_limit(xx);
		
		AdminFindTicketsForLimitModel adminFindTicketsForLimitModel = new AdminFindTicketsForLimitModel();
		adminFindTicketsForLimitModel.setAdminPage(adminPage);
		adminFindTicketsForLimitModel.setAdminTicket(list);
		
		
		return adminFindTicketsForLimitModel;
	}

	@RequestMapping("/findTickets")
	@ResponseBody
	public List<AdminTicket> findTickets() {

		List<AdminTicket> list = adminService.findTickets();
		return list;
	}

}
