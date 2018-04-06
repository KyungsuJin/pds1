package com.test.mall1.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.mall1.board.service.Board;
import com.test.mall1.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="getBoardList", method = RequestMethod.GET)
	public ModelAndView selectBoard(ModelAndView mav
										,@RequestParam(value="currentPage", defaultValue="1") int currentPage
										,@RequestParam(value="pagePerRow", defaultValue="2") int pagePerRow) {
		logger.info(currentPage+"<--currentPage111111");
		Map<String, Object> returnMap = boardService.selectBoard(currentPage, pagePerRow);
		mav.setViewName("getBoardList");
		mav.addObject("list", returnMap.get("list"));
		mav.addObject("currentPage", returnMap.get("currentPage"));
		mav.addObject("lastPage", returnMap.get("lastPage"));
		logger.info(currentPage+"<--currentPage2222222");
		return mav;
	}
}
