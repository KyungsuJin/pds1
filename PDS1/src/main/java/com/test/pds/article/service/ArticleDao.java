package com.test.pds.article.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);

	@Autowired private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.article.service.ArticleMapper.";
	public int addArticle(Article article) {
		logger.debug("ArticleDao.addArticle 메서드 호출");
		sqlSession.insert(NS + "insertArticle", article);
		return article.getArticleId();
	}
	
	public int articleTotalCount() {
		return sqlSession.selectOne(NS+"selectArticleCount");
	}
	
	public List<Article> getArticleList(Map map){
		logger.debug("ArticleDao.getArticleList 메서드 호출");
		List<Article> list = sqlSession.selectList(NS+"selectArticleList", map);
		return list;
	}
	
	public Article getArticleContent(Article article) {
		Article resultArticle = sqlSession.selectOne(NS+"selectArticleContent", article);
		return resultArticle;
	}
	
	public void removeArticle(Article article) {
		sqlSession.delete(NS+"deleteArticle", article);
	}

}
