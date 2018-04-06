package com.test.mall1.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	public Map<String, Object> selectBoard(int currentPage, int pagePerRow) {
		logger.info("boardService 의 selectBoard 메서드 호출");
		logger.info(currentPage+"<--currentPage");
		logger.info(pagePerRow+"<--pagePerRow");
		int beginRow = (currentPage-1)*pagePerRow;
		int totalRow = boardDao.totalCountBoard();
		logger.info(beginRow+"<--beginRow");
		logger.info(totalRow+"<--totalRow");
		int lastPage = totalRow/pagePerRow;
		if(totalRow%pagePerRow != 0) {
			lastPage++;
		}
		logger.info(lastPage+"<--lastPage");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);			
		
		List<Board> list = boardDao.selectBoardList(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("currentPage", currentPage);
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
				
		return returnMap;
	}
}
