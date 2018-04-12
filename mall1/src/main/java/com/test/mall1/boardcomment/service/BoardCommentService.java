package com.test.mall1.boardcomment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentDao boardCommentDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentService.class);
	
	public Map<String, Object> resultBoardComment(int currentPage, int pagePerRow) {
		logger.info("BoardCommentService 클래스의 resultBoardComment메서드 실행");		
		Map<String,Integer> map = new HashMap<String,Integer>();
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<BoardComment> list = boardCommentDao.selectBoardCommentResult(map);
		int total = boardCommentDao.totalCountBoardComment();
		int lastPage = 0;
		if(total%pagePerRow==0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow+1;
		}
		logger.info("total:"+total);		
		logger.info("lastPage:"+lastPage);		
		logger.info("currentPage:"+ currentPage);
		logger.info("beginRow:"+ beginRow);
		logger.info("pagePerRow:"+ pagePerRow);
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("total", list);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
	
	public int addBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentService 클래스의 addBoardComment메서드 실행");
		int row = boardCommentDao.insertBoardComment(boardComment);
		return row;
		}
}
