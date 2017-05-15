package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.ScoreDao;
import com.lanou.entity.Score;
import com.lanou.service.ScoreService;

public class ScoreServiceImpl  implements ScoreService{

	private ScoreDao scoreDao;
	
	
	@Override
	public void saveScoer(Score score) {
		scoreDao.saveScore(score);	
	}

	@Override
	public List<Score> findScoer() {
		List<Score> list = scoreDao.findScore();
		return list;
	}

	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
}
