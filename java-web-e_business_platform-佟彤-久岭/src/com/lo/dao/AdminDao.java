package com.lo.dao;

import java.util.List;
import java.util.Map;

import com.lo.entity.AdminForTimeCheck;
import com.lo.entity.AdminTicket;
import com.lo.entity.AdminUser;

public interface AdminDao {

	public List<AdminUser> findAdminUsers(); 
	
	public List<AdminTicket> findTickets();
	
	public List<AdminTicket> findTickets(AdminTicket adminTicket);
	
	public void adminAddTicket(AdminTicket adminTicket);
	
	public List<AdminTicket> findTicketsForTime(AdminForTimeCheck adminSeeTicketTime);
	
	public void updateStatusToO(int tid);//updateStatusTo1
	
	public void updateStatusTo1(int tid);
	
	public void updateTickets(AdminTicket adminTicket);
	
	public int findTicketCount();
	
	public List<AdminTicket> findTickets_limit(Map<String, Object> ticket_limit);
	
	public int findTicketCountForTime(AdminForTimeCheck adminSeeTicketTime);
	
	public List<AdminTicket> findTicketForTime_limit(Map<String,Object> xx);
}













