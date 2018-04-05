package com.test.mall1.boardcomment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentDao boardCommentDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentService.class);
	
	public List<BoardComment> resultBoardComment() {
		logger.info("BoardCommentService 클래스의 resultBoardComment메서드 실행");		
		return boardCommentDao.selectBoardComment();
	}
	
	public int addBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentService 클래스의 addBoardComment메서드 실행");
		int row = boardCommentDao.insertBoardComment(boardComment);
		return row;
		}
}
