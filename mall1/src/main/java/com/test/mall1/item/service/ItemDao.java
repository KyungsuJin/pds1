package com.test.mall1.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS="com.test.mall1.item.service.ItemMapper.";
	
/*	public Member selectMemberById(Member member) {
		return sqlSession.selectOne(NS+"selectMemberById",member);
	}*/
	
	public int totalCountMember() {
		return sqlSession.selectOne(NS+"totalCountMember");
	}
	
	
	public List<Item> selectItemList(Map<String,Integer> map){
		return sqlSession.selectList(NS+"selectItemList",map);
	}
	
	public int insertItem(Item item) {
		logger.info("ItemDao 클래스의 insertItem 메서드실행");
		int row =sqlSession.insert(NS+"insertItem",item);
		return row;
	}
}
