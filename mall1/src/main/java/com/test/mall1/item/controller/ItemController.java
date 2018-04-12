package com.test.mall1.item.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login";
		
	}

	@RequestMapping(value="/getItemList", method = RequestMethod.GET)
	public String getItemList(Model model//defaultValue 만약에 넘어온값이 null이면 1  required=true 무조건값이 넘어와야함
								,@RequestParam(value="currentPage",defaultValue="1")int currentPage
								) {
		int pagePerRow=2;
		Map<String,Object> map= itemService.getItemList(currentPage,pagePerRow);
		
		//Model model  == request.setAttribute();
		model.addAttribute("list",map.get("list"));
		model.addAttribute("total",map.get("total"));
		model.addAttribute("currentPage",currentPage);
		return "getItemList";
	}
	
	@RequestMapping(value="/addItem", method = RequestMethod.GET)
	public String addItem(Model model
						,@RequestParam(value="categoryNo")int categoryNo) {
		logger.info("ddddddddddd");
		model.addAttribute("categoryNo", categoryNo);
		return "addItem";
	}
	@RequestMapping(value="/addItem", method = RequestMethod.POST)
	public String addItem(Item item) {
		itemService.addItem(item);
		return "redirect:/";
	}
}
