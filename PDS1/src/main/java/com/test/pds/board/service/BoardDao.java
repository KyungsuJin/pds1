package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	private static final Logger logger= LoggerFactory.getLogger(BoardDao.class);
	final String NS ="com.test.pds.board.service.BoardMapper.";
	
	public int addBoard(Board board) {
		logger.debug("BoardDao.addBoard");
		sqlSession.insert(NS+"insertBoard",board);
		int boardId =board.getBoardId();
		logger.debug("boardId : "+board.getBoardId());
		return boardId;
	}
	public void getBoardList() {
		sqlSession.selectList(NS+"");
	}
}
