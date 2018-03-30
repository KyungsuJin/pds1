package com.test.mall1.board_comment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall1.board_comment.service.Board_comment;
import com.test.mall1.board_comment.service.Board_commentService;

@Controller
public class Board_commentCotroller {
	@Autowired
	Board_commentService board_commentService;
	private static final Logger logger = LoggerFactory.getLogger(Board_commentCotroller.class);
	
	@RequestMapping(value = "/addBoard_Comment", method = RequestMethod.POST)
	public String addBoard_commnet(Board_comment board_comment) {
		board_commentService.addBoard_comment(board_comment);
		return "redirect:/index";
	}
}
