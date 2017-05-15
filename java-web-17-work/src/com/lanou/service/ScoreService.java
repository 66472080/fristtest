package com.lanou.service;

import java.util.List;

import com.lanou.entity.Score;

public interface ScoreService {
	
  public void saveScoer(Score score);
  public List<Score> findScoer();
	

}
