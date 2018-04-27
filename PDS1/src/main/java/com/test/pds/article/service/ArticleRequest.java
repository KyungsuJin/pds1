package com.test.pds.article.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticleRequest {
	private int articleId;
	private String articleTitle; // article_title
	private String articleContent; // article_content
	private List<Integer> articleDeleteList;
	private List<MultipartFile> multipartFile;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public List<Integer> getArticleDeleteList() {
		return articleDeleteList;
	}
	public void setArticleDeleteList(List<Integer> articleDeleteList) {
		this.articleDeleteList = articleDeleteList;
	}
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "ArticleRequest [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + ", articleDeleteList=" + articleDeleteList + ", multipartFile=" + multipartFile
				+ "]";
	}
}
