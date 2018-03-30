package com.test.mall1.boardcomment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall1.boardcomment.service.BoardComment;
import com.test.mall1.boardcomment.service.BoardCommentService;

@Controller
public class BoardCommentCotroller {
	@Autowired
	private BoardCommentService boardCommentService;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentCotroller.class);
	
	@RequestMapping(value = "/addBoardComment", method = RequestMethod.POST)
	public String addBoardCommnet(BoardComment boardComment) {
		boardCommentService.addBoardComment(boardComment);
		return "redirect:/index";
	}
}