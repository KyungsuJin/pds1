package com.test.pds.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.service.ArticleMapper.";
	public void addArticle(Article article) {
		System.out.println("dag호출" + article.toString());
		sqlSession.insert(NS + "insertArticle", article);
		System.out.println("test 1 ");
		article.getArticleFile().setArticleId(article.getArticleId());
		System.out.println("mapper 전 " + article.toString());
		sqlSession.insert(NS + "insertArticleFile", article.getArticleFile());
	}
}
