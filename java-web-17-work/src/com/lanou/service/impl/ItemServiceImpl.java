package com.lanou.service.impl;

import java.util.List;

import com.lanou.dao.ItemDao;
import com.lanou.entity.Item;
import com.lanou.service.ItemService;

public class ItemServiceImpl implements ItemService{
      
    private ItemDao itemDao;
	
	@Override
	public List<Item> findItem() {
		List<Item> list = itemDao.findItem();
		return list;
	}

	
	
	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

}
