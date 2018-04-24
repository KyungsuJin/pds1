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
	
	
	////////////////////// 게시글 작성 후 파일 업로드 //////////////////////
	@RequestMapping(value="/addArticle", method=RequestMethod.GET)
	public String addArticle() {
		logger.debug("ArticleController.addArticle GET 방식 호출");
		return "addArticle";
	}
	
	@RequestMapping(value="/addArticle", method=RequestMethod.POST)
	public String addArticle(ArticleRequest articleRequest, HttpSession session) {
		logger.debug("ArticleController.addArticle POST 방식 호출");
		String path = session.getServletContext().getRealPath("/upload");
		logger.debug("ArticleController.addArticle.path : " + path);
		articleService.addArticle(articleRequest, path);
		
		return "redirect:/";
	}
	
	////////////////////// 게시물 리스트 출력 //////////////////////	
	
	@RequestMapping(value="/getArticleList", method=RequestMethod.GET)
	public String getArticleList(Model model) {
		logger.debug("ArticleController.getArticleList GET 방식 호출");
		model.addAttribute("list",articleService.getArticleList());
		return "getArticleList";
	}
	
	////////////////////// 게시물 내용 출력 //////////////////////
	
	@RequestMapping(value="/getArticleContent", method=RequestMethod.GET)
	public String getArticleContent(Model model) {
		logger.debug("ArticleController.getArticleContent GET 방식 호출");
		model.addAttribute("list",articleService.getArticleList());
		return "getArticleList";
	}
	
}
