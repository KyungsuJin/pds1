package com.test.mall1.board.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="deleteBoard")
	public String deleteBoard(@RequestParam(value="boardNo") int boardNo) {
		logger.info("deleteBoard_BoardController");
		boardService.deleteBoard(boardNo);
		return "redirect:/getBoardList";
	}
	@RequestMapping(value="updateBoard", method = RequestMethod.POST)
	public String updateBoard(Board board) {
		logger.info("updateBoard_BoardController");
		boardService.updateBoard(board);
		return "redirect:/";
	}
	@RequestMapping(value="boardDetailView", method = RequestMethod.GET)
	public ModelAndView boardDetailViews(ModelAndView mav
										,@RequestParam(value="boardNo") int boardNo) {
		logger.info("boardDetailView_BoardController");
		Board board = boardService.boardDetailView(boardNo);
		mav.addObject("board", board);
		mav.setViewName("boardDetailView");
		return mav;
	}
	@RequestMapping(value="addBoard", method = RequestMethod.GET)
	public String addBoard() {
		logger.info("addBoard_RequestMethod.GET_BoardController");
		return "addBoard";
	}
	@RequestMapping(value="addBoard", method = RequestMethod.POST)
	public String addBoard(Board board) {
		logger.info("addBoard_RequestMethod.POST_BoardController");
		boardService.addBoard(board);
		return "redirect:/";
	}
	
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
