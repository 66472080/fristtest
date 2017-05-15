package com.lo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lo.dao.AdminDao;
import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminTicket;
import com.lo.entity.AdminUser;
import com.lo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDao adminDao ;
	
	
	
	@Override
	public List<AdminUser> findAdminUsers() {
		return adminDao.findAdminUsers();
	}



	@Override
	public List<AdminTicket> findTickets() {
		
		return adminDao.findTickets();
	}



	@Override
	public void adminAddTicket(AdminTicket adminTicket) {
		adminDao.adminAddTicket(adminTicket);		
	}



	@Override
	public List<AdminTicket> findTicketsForTime(AdminForTimeCheck adminSeeTicketTime) {
		
		return adminDao.findTicketsForTime(adminSeeTicketTime);
	}



	@Override
	public void updateStatusToO(int tid) {
		adminDao.updateStatusToO(tid);		
	}

	@Override
	public void updateStatusTo1(int tid) {
		adminDao.updateStatusTo1(tid);		
	}



	@Override
	public List<AdminTicket> findTickets(AdminTicket adminTicket) {
		return adminDao.findTickets(adminTicket);		
	}



	@Override
	public void updateTickets(AdminTicket adminTicket) {
		adminDao.updateTickets(adminTicket);		
	}



	@Override
	public int findTicketCount() {
		
		return adminDao.findTicketCount();
	}



	@Override
	public List<AdminTicket> findTickets_limit(Map<String, Object> ticket_limit) {
		
		return adminDao.findTickets_limit(ticket_limit);
	}



	@Override
	public List<AdminTicket> findTicketForTime_limit(Map<String,Object> adminSeeTicketTime) {
		
		return adminDao.findTicketForTime_limit(adminSeeTicketTime);
	}



	@Override
	public int findTicketCountForTime(AdminForTimeCheck adminSeeTicketTime) {
		return adminDao.findTicketCountForTime(adminSeeTicketTime);
	}



	

}
