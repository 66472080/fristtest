package com.lanou.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.Score;

public class ScoreDao {
	
	private HibernateTemplate template;
	private Score score;
	
	
//	保存分数
	public void saveScore(Score score){
		template.save(score);
	}
//	查分
	public List<Score> findScore(){
		String hql = "form Score";
		List<Score> list = (List<Score>) template.find(hql);
		return list;
	}
	
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
}
