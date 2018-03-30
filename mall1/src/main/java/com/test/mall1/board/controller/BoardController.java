package com.test.mall1.board.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.mall1.board.service.Board;
import com.test.mall1.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="getBoardList")
	public ModelAndView selectBoard() {
		ArrayList<Board> list = boardService.selectBoard();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList");
		mav.addObject("list", list);
		
		return mav;
	}
}
