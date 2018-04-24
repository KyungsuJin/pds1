package com.test.pds.article.service;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleService {
	
	@Autowired private ArticleDao articleDao;
	
	public void addArticle(ArticleRequest articleRequest, String path) {
		List<MultipartFile> multipartFileList = articleRequest.getMultipartFile();
		
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());
			
		for(MultipartFile multipartFile : multipartFileList) {
			ArticleFile articleFile = new ArticleFile();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().replaceAll("-", "");
			articleFile.setArticleFileName(fileName);
			articleFile.setArticleFileRealName(multipartFile.getOriginalFilename());
			String fileExt = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
			articleFile.setArticleFileExt(fileExt);
			articleFile.setArticleFileType(multipartFile.getContentType());
			articleFile.setArticleFileSize(multipartFile.getSize());
			System.out.println(articleFile.toString());
			File file = new File("D:/upload/"+fileName+"."+fileExt);
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
}
