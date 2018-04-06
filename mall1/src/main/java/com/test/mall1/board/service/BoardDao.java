package com.test.mall1.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	final String NS = "com.test.mall1.board.service.BoardMapper.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int totalCountBoard() {		
		return sqlSession.selectOne(NS+"totalCountBoard");
	}
	public List<Board> selectBoardList(Map<String, Integer> map) {
		logger.info("BoardDao 클래스의 selectBoardList");
		List<Board> list = sqlSession.selectList("com.test.mall1.board.service.BoardMapper.selectBoardList", map);
		logger.info("BoardDao 클래스의 selectBoardList2");
		return list;
	}
}
