package com.test.mall1.boardcomment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentDao boardCommentDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentService.class);
	
	public String addBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentService 클래스의 addBoardComment메서드 실행");
		boardCommentDao.insertBoardComment(boardComment);
		return null;
	}
	
	public String resultBoardComment() {
		logger.info("BoardCommentService 클래스의 resultBoardComment메서드 실행");
		boardCommentDao.allBoardComment();
		return null;
	}
}
