package com.test.mall1.item.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	public List<Item> getItemList(){
		return itemDao.selectItemList();
	}
	public int addItem(Item item) {
		logger.info("ItemService 의 addItem 메서드 실행");
		int row =itemDao.insertItem(item);
		return row;
	}
}
