package com.test.mall1.boardcomment.service;

import java.util.List;
import java.util.Map;

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
	
	public int totalCountBoardComment() {
		logger.info("MemberDao 클래스의 totalCountBoardComment메서드 실행");
		return sqlSession.selectOne(NS+"totalCountBoardComment");
	}
	
/*	public BoardComment selectBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentDao 클래스의 selectBoardCommentResult메서드 실행");
		return sqlSession.selectOne(NS+"selectBoardComment");
	}*/
	
	public List<BoardComment> selectBoardCommentResult(Map<String,Integer> map){
		logger.info("BoardCommentDao 클래스의 selectBoardComment메서드 실행");
		return sqlSession.selectList(NS+"selectBoardCommentResult",map);
	}
	
	public int insertBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentDao 클래스의 insertBoardComment메서드 실행");
		int row = sqlSession.insert(NS+"insertBoardComment", boardComment);
		return row;		
	}
}
