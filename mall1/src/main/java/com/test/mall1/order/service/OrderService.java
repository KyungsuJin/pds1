package com.test.mall1.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	public void addOrder(Order order) {
		logger.info("sdfasf");
		orderDao.addOrder(order);
	}

}
