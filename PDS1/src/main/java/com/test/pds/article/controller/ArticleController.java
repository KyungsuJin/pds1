package com.test.pds.article.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
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
	public String addArticle(Model model
			,@RequestParam(value="currentPage") int currentPage
			,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("ArticleController.addArticle GET 방식 호출");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
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
		
		
		return "redirect:/getArticleList";
	}
	
	////////////////////// 게시물 리스트 출력 //////////////////////	
	
	@RequestMapping(value="/getArticleList", method=RequestMethod.GET)
	public String getArticleList(Model model
									,@RequestParam(value="currentPage", defaultValue="1" ) int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {		
		logger.debug("ArticleController.getArticleList GET 방식 호출");
		Map map = articleService.getArticleList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("firstPage", map.get("firstPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("beforePage", map.get("beforePage"));
		model.addAttribute("afterPage", map.get("afterPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "getArticleList";
	}
	
	////////////////////// 게시물 내용 출력 //////////////////////
	
	@RequestMapping(value="/getArticleContent", method=RequestMethod.GET)
	public String getArticleContent(Model model
										,Article article
										,@RequestParam(value="currentPage") int currentPage
										,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("ArticleController.getArticleContent GET 방식 호출");
		model.addAttribute("article",articleService.getArticleContent(article));
		model.addAttribute("downloadPath", SystemPath.DOWNLOAD_PATH);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "getArticleContent";
	}
	
	////////////////////// 게시물 삭제 //////////////////////
	
	@RequestMapping(value="/removeArticle", method=RequestMethod.GET)
	public String removeArticle(Article article
									,@RequestParam(value="currentPage") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("ArticleController.removeArticle GET 방식 호출");
		articleService.removeArticle(article);
		return "redirect:/getArticleList?currentPage=" + currentPage + "&pagePerRow=" + pagePerRow;
	}
}
