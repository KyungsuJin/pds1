package com.test.mall1.category.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall1.category.service.Category;
import com.test.mall1.category.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
	public String getCategoryList(Model model) {
		List<Category> list = categoryservice.getCategoryList();
		model.addAttribute("list", list);
		return "getCategoryList";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addController() {
		logger.info("CategoryController");
		return "addCategory";
	}
	@RequestMapping(value="/addCategory", method = RequestMethod.POST)
	public String addController(Category category) {
		logger.info("CSDFDSFSDFSDFSDFDSFSF444444444444444444");
		categoryservice.addCategory(category);
		return "redirect:/";
	}

}
