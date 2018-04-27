package com.test.pds.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;
import com.test.pds.article.controller.ArticleController;

@Service
@Transactional
public class ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Autowired private ArticleDao articleDao;
	@Autowired private ArticleFileDao articleFileDao;
	
	public void addArticle(ArticleRequest articleRequest, String path) {
		logger.debug("ArticleService.addArticle 메서드 호출");
		logger.debug("ArticleService.addArticle.articleRequest : " + articleRequest.toString());
		logger.debug("ArticleService.addArticle.path : " + path);
		List<MultipartFile> multipartFileList = articleRequest.getMultipartFile();
		
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
		int articleId = articleDao.addArticle(article);
		logger.debug("ArticleService.addArticle.articleId : " + articleId);
		for(MultipartFile multipartFile : multipartFileList) {
			logger.debug("ArticleService.addArticle.multipartFile : " + multipartFile);
			ArticleFile articleFile = new ArticleFile();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().replaceAll("-", "");
			logger.debug("ArticleService.addArticle.fileName : " + articleId);
			articleFile.setArticleFileName(fileName);
			articleFile.setArticleFileRealName(multipartFile.getOriginalFilename());
			articleFile.setArticleId(articleId);
			String fileExt = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
			articleFile.setArticleFileExt(fileExt);
			articleFile.setArticleFileType(multipartFile.getContentType());
			articleFile.setArticleFileSize(multipartFile.getSize());
			File file = new File(SystemPath.DOWNLOAD_PATH+fileName+"."+fileExt);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			articleFileDao.addArticleFile(articleFile);
		}
	}
	
	public Map<String, Object> getArticleList(int currentPage, int pagePerRow){
		logger.debug("ArticleService.getArticleList 호출");
		int totalRow = articleDao.articleTotalCount();
		int firstPage = 1;
		int lastPage = totalRow/pagePerRow;
		if(totalRow%pagePerRow != 0) {
			lastPage++;
		}
		int beforePage = ((currentPage-1)/10)*10;
		int afterPage = ((currentPage-1)/10)*10 +11;
		
		Map pageMap = new HashMap<String, Integer>();
		pageMap.put("beginRow", (currentPage-1)*10);
		pageMap.put("pagePerRow", pagePerRow);
		
		Map map = new HashMap<String, Object>();
		List<Article> list = articleDao.getArticleList(pageMap);
		map.put("list", list);
		map.put("firstPage", firstPage);
		map.put("lastPage", lastPage);
		map.put("beforePage", beforePage);
		map.put("afterPage", afterPage);
		logger.debug("ArticleService.getArticleList.list : " + list);
		logger.debug("ArticleService.getArticleList.firstPage : " + firstPage);
		logger.debug("ArticleService.getArticleList.lastPage : " + lastPage);
		logger.debug("ArticleService.getArticleList.beforePage : " + beforePage);
		logger.debug("ArticleService.getArticleList.afterPage : " + afterPage);
		return map;
	}
	
	public Article getArticleContent(Article article) {
		Article resultArticle = articleDao.getArticleContent(article);
		return resultArticle;
	}
	
	public void removeArticle(Article article) {
		if(articleFileDao.articleFileTotalCount(article) != 0) {
			articleFileDao.removeArticleFile(article);
		}
		articleDao.removeArticle(article);
	}
}
