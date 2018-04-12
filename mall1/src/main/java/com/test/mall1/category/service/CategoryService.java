package com.test.mall1.category.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

	public Map<String,Object> getCategoryList(int currentPage,int pagePerRow) {
		int beginRow =(currentPage-1)*pagePerRow;
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Category> list=categoryDao.selecstCategoryList(map);
		int total = categoryDao.totalCountCategory();
		int lastPage=0;
		if(total%pagePerRow==0) {
			lastPage=total/pagePerRow;
		}else {
			lastPage=total/pagePerRow+1;
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}
	
	public int addCategory(Category category) {
		logger.info("CategoryService addCategory");
		int row = categoryDao.insertCategry(category);
		return row;

	}
}
