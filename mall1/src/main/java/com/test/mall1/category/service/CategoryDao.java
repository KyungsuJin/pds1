package com.test.mall1.category.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String FS = "com.test.mall1.category.service.CategoryMapper.";
	
	public List<Category> selecstCategoryList(Map<String,Integer> map){
		return sqlSession.selectList(FS+"selectCategoryList",map);
	}
	public int totalCountCategory() {
		return sqlSession.selectOne(FS+"totalCountCategory");
	}

	public int insertCategry(Category category) {
		logger.info("CategoryDao 의 insertCategry메서드 실행564");
		int row = sqlSession.insert(FS+"insertCategory",category);
		return row;
	}
}
