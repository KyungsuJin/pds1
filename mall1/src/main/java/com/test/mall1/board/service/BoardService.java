package com.test.mall1.board.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	public ArrayList<Board> selectBoard() {
		logger.info("boardService 의 selectBoard 메서드 호출");
		ArrayList<Board> lsit = boardDao.selectBoardList();
		
		return lsit;
	}
}
