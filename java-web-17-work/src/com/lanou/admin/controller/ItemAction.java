package com.lanou.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.lanou.entity.Item;
import com.lanou.entity.Score;
import com.lanou.service.ItemService;
import com.lanou.service.ScoreService;


public class ItemAction {
 
	private ItemService itemService;
	private Item item;
//	private Score score;
//	private ScoreService scoreService;
	

	
	//	查题
	public String exam(){
		HttpServletRequest  req=ServletActionContext.getRequest();
		List<Item> list = itemService.findItem();
		req.setAttribute("list",list);
		return "exam1";	//跳转到考试页面
	}
//	选择
	public String xuan(){
		 int i;
		 int f=0;
		 HttpServletRequest req = ServletActionContext.getRequest();
		 HttpSession session = req.getSession();
			for (i = 1; i > 0; i++) {	
				if (req.getParameter("daan" + i) != null && req.getParameter("daan"+ i).length() != 0) {
					String b = req.getParameter(String.valueOf(i));
					String a = req.getParameter("daan"+i);
					if(a.equals(b)){
						 f++;
					}
				}else{
					break;
				}
			}
			session.setAttribute("f", f);
			System.out.println(f);
		return "examlog";//提交跳转到考试记录界面
		
		
	}
//   public String  saveScore(){
//	   HttpServletRequest req = ServletActionContext.getRequest();
//	   HttpSession session = req.getSession();
//	   
//	   session.setAttribute("sid", score.getId());
//	   session.setAttribute("score",score.getScore());
//	   session.setAttribute("time", score.getTime());
//	   int a=  (int) session.getAttribute("f");
//	   score.setScore(a);
//	   scoreService.saveScoer(score);
//	   return "";
//   }
//    	
	    

	
//public Score getScore() {
//	return score;
//}
//public void setScore(Score score) {
//	this.score = score;
//}


	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
//	public void setScoreService(ScoreService scoreService) {
//		this.scoreService = scoreService;
//	}
}
