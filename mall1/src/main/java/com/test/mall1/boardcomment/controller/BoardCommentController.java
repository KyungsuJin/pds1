package com.test.mall1.boardcomment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall1.boardcomment.service.BoardComment;
import com.test.mall1.boardcomment.service.BoardCommentService;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentController.class);
	
	@RequestMapping(value = "/addBoardComment", method = RequestMethod.GET)
	public String addBoardComment() {
		logger.info("BoardCommentCotroller 클래스의 addBoardComment forward메서드 실행");
		return "addBoardCommentForm";
	}
	@RequestMapping(value = "/addBoardCommentpro", method = RequestMethod.POST)
	public String addBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentCotroller클래스의 addBoardComment redirect메서드 실행");
		boardCommentService.addBoardComment(boardComment);
		return "redirect:/addBoardCommentResult";
	}
	
	@RequestMapping(value = "/addBoardCommentResult", method = RequestMethod.GET)
	public String addBoardCommentResult() {
		logger.info("BoardCommentCotroller 클래스의 addBoardCommentResult forward메서드 실행");
		boardCommentService.resultBoardComment();
		return "addBoardCommentResult";
	}
}