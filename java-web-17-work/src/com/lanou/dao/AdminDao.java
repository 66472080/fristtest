package com.lanou.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.lanou.entity.Admin;
import com.lanou.entity.Item;
import com.lanou.entity.User;

public class AdminDao {
	
	private HibernateTemplate hibernateTemplate;
	private Session session;
	private Item item;
	private User user;
	
	

	public List<User> findUser(){
		String hql="from User";
		List<User> lu = (List<User>) hibernateTemplate.find(hql);
		return lu;
		
	}
	public List<Admin> findAdmin(){
		
		String hql="from Admin";
		List<Admin> la = (List<Admin>) hibernateTemplate.find(hql);
		
		return la;
	}
	public void deleteItem(int a){
//		String hql="delete Item where id=?";
//		Query query = session.createQuery(hql);
//		query.setParameter(0, a);
		item.setId(a);
	
		hibernateTemplate.delete(item);
	}
//	public void updateItem(int a){
//		String hql="UPDATE score set c_name="挖掘机" where id =5";
//		Query query = session.createQuery(hql);
//		query.setParameter(0, a);
//	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void saveadd(Item item){
		item.setId(item.getId());
		item.setQusetion(item.getQusetion());
		item.setOption_a(item.getOption_a());
		item.setOption_b(item.getOption_b());
		item.setOption_c(item.getOption_c());
		item.setOption_d(item.getOption_d());
		item.setAnswer(item.getAnswer());
		hibernateTemplate.save(item);
	}
	public void saveItem(Item item) {
//		String hql="update Item set id=? ,set qusetion=?,option_a=?,option_b=?,option_c=?,option_d=?,answer=? where id =?";
//		Query query = session.createQuery(hql);
//		query.setParameter(0, item.getId());
//		query.setParameter(1, item.getQusetion());
//		query.setParameter(2, item.getOption_a());
//		query.setParameter(3, item.getOption_b());
//		query.setParameter(4, item.getOption_c());
//		query.setParameter(5, item.getOption_d());
//		query.setParameter(6, item.getAnswer());
//		query.setParameter(7, item.getId());
		item.setId(item.getId());
		item.setQusetion(item.getQusetion());
		item.setOption_a(item.getOption_a());
		item.setOption_b(item.getOption_b());
		item.setOption_c(item.getOption_c());
		item.setOption_d(item.getOption_d());
		item.setAnswer(item.getAnswer());
		hibernateTemplate.update(item);
		
	}
	public List<Item> findItem() {
		String hql="from Item";
		List<Item> li=(List<Item>) hibernateTemplate.find(hql);
		return li;
		
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
