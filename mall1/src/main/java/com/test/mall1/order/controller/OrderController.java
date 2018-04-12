package com.test.mall1.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall1.order.service.Order;
import com.test.mall1.order.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@RequestMapping(value="/addOrder",method=RequestMethod.GET)
	public String orderItem(Model model
						,@RequestParam(value="itemNo")int itemNo
						,@RequestParam(value="itemName")String itemName
						,@RequestParam(value="itemPrice")int itemPrice
						) {
		logger.info("addOrder GET 방식 실행");
		model.addAttribute("itemNo",itemNo);
		model.addAttribute("itemName",itemName);
		model.addAttribute("itemPrice",itemPrice);
		
		return "addOrder";
	}
	
	@RequestMapping(value="/addOrder",method=RequestMethod.POST)
	public String addOrder(Order order) {
		logger.info(order.getItemNo()+"itemNo");
		logger.info(order.getOrderDate()+"getOrderDate");
		logger.info(order.getMemberNo()+"getMemberNo");
		logger.info(order.getOrderNo()+"getOrderNo");
		orderService.addOrder(order);
		return "redirect:/";
	}
	
}
