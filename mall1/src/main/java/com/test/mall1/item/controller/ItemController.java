package com.test.mall1.item.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall1.item.service.Item;
import com.test.mall1.item.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@RequestMapping(value="/getItemList", method = RequestMethod.GET)
	public String getItemList(Model model) {
		List<Item> list = itemService.getItemList();
		//Model model  == request.setAttribute();
		model.addAttribute("list",list);
		return "getItemList";
	}
	
	@RequestMapping(value="/addItem", method = RequestMethod.GET)
	public String addItem() {
		logger.info("ddddddddddd");
		return "addItem";
	}
	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public String addItem(Item item) {
		itemService.addItem(item);
		return "redirect:/";
	}
}
