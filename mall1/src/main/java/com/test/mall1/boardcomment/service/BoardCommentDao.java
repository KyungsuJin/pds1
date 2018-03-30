package com.test.mall1.boardcomment.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCommentDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentDao.class);
	
	public void insertBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentDao 클래스의 insertBoardComment메서드 실행");
	}
	
	public ArrayList<BoardComment> allBoardComment(){
		logger.info("BoardCommentDao 클래스의 allBoardComment메서드 실행");
		return null;
	}
}
