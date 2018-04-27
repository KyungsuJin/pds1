package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDao {
	private static final Logger logger = LoggerFactory.getLogger(ArticleFileDao.class);

	final String NS = "com.test.pds.article.service.ArticleFileMapper.";
	
	@Autowired SqlSessionTemplate sqlSession;
	
	public void addArticleFile(ArticleFile articleFile) {
		logger.debug("ArticleFileDao.addArticleFile 메서드 호출");
		sqlSession.insert(NS + "insertArticleFile", articleFile);
	}
	
	public int articleFileTotalCount(Article article) {
		return sqlSession.selectOne(NS+"selectArticleFileCount", article);
	}
	
	public void removeAllArticleFile(int articleId) {
		sqlSession.delete(NS+"deleteAllArticleFile", articleId);
	}
	
	public void removeArticleFile(int articleFileId) {
		sqlSession.delete(NS+"deleteArticleFile", articleFileId);
	}
}
