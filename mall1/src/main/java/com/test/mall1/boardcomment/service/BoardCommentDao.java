package com.test.mall1.boardcomment.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCommentDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentDao.class);
	
	@Autowired private SqlSessionTemplate sqlSession;
	
	final String NS ="com.test.mall1.boardcomment.service.BoardCommentMapper.";
	
	public List<BoardComment> selectBoardComment(){
		logger.info("BoardCommentDao 클래스의 allBoardComment메서드 실행");
		return sqlSession.selectList(NS+"selestBoardComment");
	}
	
	public int insertBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentDao 클래스의 insertBoardComment메서드 실행");
		int row = sqlSession.insert(NS+"insertBoardComment", boardComment);
		return row;		
	}
}
