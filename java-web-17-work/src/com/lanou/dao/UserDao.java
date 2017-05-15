package com.lanou.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lanou.entity.User;

public class UserDao {

	private HibernateTemplate template;
	private User user;

	// 添加用户
	public void saveUser(User user) {
		template.save(user);
	}

	// 删除用户
	public void deleteUser(int id) {
		user.setUid(id);
		template.delete(user);
	}

	// 修改用户
	public void updateUser(User user) {
		user.setIdnumber(user.getIdnumber());
		user.setName(user.getName());
		user.setPassword(user.getPassword());
		user.setTelno(user.getTelno());
		user.setUid(user.getUid());
		user.setUsername(user.getUsername());
		template.update(user);

	}

	// 查找用户
	public List<User> findUser() {
		String hql = "from User";
		List<User> list = (List<User>) template.find(hql);
		return list;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
