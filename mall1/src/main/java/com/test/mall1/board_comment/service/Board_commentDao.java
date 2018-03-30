package com.test.mall1.board_comment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Board_commentDao {
	private static final Logger logger = LoggerFactory.getLogger(Board_commentDao.class);
	
	public void insertBoard_comment(Board_comment board_comment) {
		logger.info("Board_commentDao 클래스의 insertBoard_comment메서드 실행");
	}
}
