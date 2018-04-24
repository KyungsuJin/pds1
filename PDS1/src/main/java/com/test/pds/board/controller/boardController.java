package com.test.pds.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;

@Controller
public class boardController {
	@Autowired
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	
	@RequestMapping(value="addBoard",method=RequestMethod.GET)
	public String addBoard() {
		logger.info("Controller addBoard GET");
		return "addBoard";
	}
	@RequestMapping(value="addBoard",method=RequestMethod.POST)
	public String addBoard(BoardRequest boardRequest,HttpSession session) {
		logger.info("Controller addBoard POST");
		logger.info("boardDTO:"+boardRequest.toString());
		String path = session.getServletContext().getRealPath("/upload");
		boardService.addBoard(boardRequest,path);
		return "redirect:/";
	}

}
