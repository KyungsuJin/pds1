package com.test.pds.article.service;

public class ArticleFile {
	private int articleFileId;
	private String articleFileName;
	private String articleFileRealName;
	private int articleId;
	private String articleFileExt;
	private String articleFileType;
	private long articleFileSize;
	public int getArticleFileId() {
		return articleFileId;
	}
	public void setArticleFileId(int articleFileId) {
		this.articleFileId = articleFileId;
	}
	public String getArticleFileName() {
		return articleFileName;
	}
	public void setArticleFileName(String articleFileName) {
		this.articleFileName = articleFileName;
	}
	public String getArticleFileRealName() {
		return articleFileRealName;
	}
	public void setArticleFileRealName(String articleFileRealName) {
		this.articleFileRealName = articleFileRealName;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleFileExt() {
		return articleFileExt;
	}
	public void setArticleFileExt(String articleFileExt) {
		this.articleFileExt = articleFileExt;
	}
	public String getArticleFileType() {
		return articleFileType;
	}
	public void setArticleFileType(String articleFileType) {
		this.articleFileType = articleFileType;
	}
	public long getArticleFileSize() {
		return articleFileSize;
	}
	public void setArticleFileSize(long articleFileSize) {
		this.articleFileSize = articleFileSize;
	}
	@Override
	public String toString() {
		return "ArticleFile [articleFileId=" + articleFileId + ", articleFileName=" + articleFileName
				+ ", articleFileRealName=" + articleFileRealName + ", articleId=" + articleId + ", articleFileExt="
				+ articleFileExt + ", articleFileType=" + articleFileType + ", articleFileSize=" + articleFileSize
				+ "]";
	}
	
	
}
