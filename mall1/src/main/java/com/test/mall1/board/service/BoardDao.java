package com.test.mall1.board.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

	public ArrayList<Board> selectBoardList() {
		logger.info("BoardDao 클래스의 selectBoardList");
		ArrayList<Board> list = new ArrayList<Board>();
		
		int i=0;
		while(i<5) {
			Board board = new Board();
			board.setBoardNo(i+1);
			board.setBoardTitle("제목"+i);
			board.setMemberId("아이디"+i);
			list.add(board);
			i++;
		}
		
		return list;
	}
}
