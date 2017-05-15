package com.lanou.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.Item;

public class ItemDao {
	
	

	private HibernateTemplate template;
	private Item item;
	// 查找查题
	public List<Item> findItem(){
		String hql = "from Item";
		List<Item> list = (List<Item>) template.find(hql);
		return list;	
	}
	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	

}
