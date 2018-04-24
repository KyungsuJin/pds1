package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	private static Logger logger = LoggerFactory.getLogger(BoardFileDao.class);
	final String NS = "com.test.pds.board.service.BoardMapper.";
	
	public void addBoardFile(BoardFile boardFile) {
		logger.debug("BoardFileDao.addBoardFile");
		sqlSession.insert(NS+"addBoardFile",boardFile);
	}

}
