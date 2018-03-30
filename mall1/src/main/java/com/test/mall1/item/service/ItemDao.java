package com.test.mall1.item.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);
	
	public void insertItem(Item item) {
		logger.info("ItemDao 클래스의 insertItem 메서드실행");
		System.out.println(item.getItemName());
		System.out.println(item.getItemPrice());
		System.out.println(item.toString());
	}
}
