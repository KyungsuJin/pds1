package com.test.mall1.category.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	public List<Category> getCategoryList() {
		return categoryDao.selecstCategoryList();
	}
	
	public int addCategory(Category category) {
		logger.info("CategoryService addCategory");
		int row = categoryDao.insertCategry(category);
		return row;

	}
}
