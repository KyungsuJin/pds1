package com.test.mall1.board_comment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Board_commentService {
	@Autowired
	private Board_commentDao board_commentDao;
	private static final Logger logger = LoggerFactory.getLogger(Board_commentService.class);
	
	public void addBoard_comment(Board_comment board_comment) {
		logger.info("Board_commentService 클래스의 addBoard_comment메서드 실행");
		board_commentDao.insertBoard_comment(board_comment);
	}
}
