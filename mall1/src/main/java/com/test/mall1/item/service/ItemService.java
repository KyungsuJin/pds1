package com.test.mall1.item.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	public void addItem(Item item) {
		logger.info("ItemService 의 addItem 메서드 실행");
		itemDao.insertItem(item);
	}
}
