package com.lanou.admin.controller;

import java.util.List;

import com.lanou.entity.Score;
import com.lanou.service.ScoreService;
import com.opensymphony.xwork2.ActionSupport;

public class ScoreAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ScoreService scoreService;
    private Score score;
    
    
    public String saveScore(){
    
    	
    	    scoreService.saveScoer(score);
		return "saveScore";  
    }
//    public String findScore(){
//    	   List<Score> list = scoreService.findScoer();
//		return "findScore";
//    }
    
    
    
	public ScoreService getScoreService() {
		return scoreService;
	}
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
    
	
	
	
	
	

}
