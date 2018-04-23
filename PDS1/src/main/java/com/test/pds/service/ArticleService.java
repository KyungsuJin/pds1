package com.test.pds.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleService {
	
	@Autowired ArticleDao articleDao;
	
	public void addArticle(ArticleRequest articleRequest, String path) {
		MultipartFile multipartFile = articleRequest.getMultipartFile();
		
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
		
		ArticleFile articleFile = new ArticleFile();
		
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString().replaceAll("-", "");
		articleFile.setArticleFileName(fileName);
		String fileExt = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
		articleFile.setArticleFileExt(fileExt);
		articleFile.setArticleFileType(multipartFile.getContentType());
		articleFile.setArticleFileSize(multipartFile.getSize());
		System.out.println(articleFile.toString());
		
		File file = new File(path+"/"+fileName+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		article.setArticleFile(articleFile);
		
		articleDao.addArticle(article);
		
	}
}
