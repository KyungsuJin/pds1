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
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;
import com.test.pds.article.service.Article;
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
	public String addArticle(ArticleRequest articleRequest, HttpSession session, Model model) {
		logger.debug("ArticleController.addArticle POST 방식 호출");
		for(MultipartFile multipartFile : articleRequest.getMultipartFile()) {
			if(multipartFile.getContentType().equals("application/x-msdownload")) {
				model.addAttribute("article", articleRequest);
				model.addAttribute("exeFileName", multipartFile.getOriginalFilename());
				return "addArticle";
			}
		}
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
	public String getArticleContent(Model model, Article article) {
		logger.debug("ArticleController.getArticleContent GET 방식 호출");
		model.addAttribute("article",articleService.getArticleContent(article));
		model.addAttribute("downloadPath", SystemPath.DOWNLOAD_PATH);
		return "getArticleContent";
	}
}
