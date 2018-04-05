package com.test.mall1.boardcomment.controller;

import java.util.List;

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
	
	@RequestMapping(value = "/BoardCommentResult", method = RequestMethod.GET)
	public String addBoardCommentResult(Model model) {
		logger.info("BoardCommentCotroller 클래스의 BoardCommentResult forward메서드 실행");
		List<BoardComment> result = boardCommentService.resultBoardComment();
		model.addAttribute("result",result);
		return "BoardCommentResult";
	}
	
	@RequestMapping(value = "/addBoardCommentForm", method = RequestMethod.POST)
	public String addBoardComment(BoardComment boardComment) {
		logger.info("BoardCommentCotroller클래스의 addBoardComment redirect메서드 실행");
		boardCommentService.addBoardComment(boardComment);
		return "redirect:/BoardCommentResult";
	}
	
	@RequestMapping(value = "/addBoardCommentForm", method = RequestMethod.GET)
	public String addBoardComment() {
		logger.info("BoardCommentCotroller 클래스의 addBoardComment forward메서드 실행");
		return "addBoardCommentForm";
	}
}