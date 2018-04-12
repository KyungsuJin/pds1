package com.test.mall1.order.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS="com.test.mall1.order.service.OrderMapper.";
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	public void addOrder(Order order) {
		logger.info("orderDao");
		sqlSession.insert(NS+"addOrder",order);
		
	}
}
