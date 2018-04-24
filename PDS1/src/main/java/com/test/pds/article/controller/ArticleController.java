package com.test.pds.article.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ArticleController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleService articleService;
	
	
	@RequestMapping(value="/addArticle", method=RequestMethod.GET)
	public String addArticle() {
		return "addArticle";
	}
	
	@RequestMapping(value="/addArticle", method=RequestMethod.POST)
	public String addArticle(ArticleRequest articleRequest, HttpSession session) {
		System.out.println(articleRequest.toString());
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		articleService.addArticle(articleRequest, path);
		//서비스에서 articleReuquest를 바꿔줘야함
		// 파일 폴더지정해서 저장해야함
		//insert해야함
		
		return "redirect:/";
	}
	
}
