package com.test.pds.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;

@Controller
public class boardController {
	@Autowired
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	//addBoard 폼 연결
	@RequestMapping(value="addBoard",method=RequestMethod.GET)
	public String addBoard() {
		logger.debug("Controller addBoard GET");
		return "addBoard";
	}
	//addBoard 폼 처리
	@RequestMapping(value="addBoard",method=RequestMethod.POST)
	public String addBoard(Model model,BoardRequest boardRequest,HttpSession session) {
		logger.debug("Controller addBoard POST");
		logger.debug("boardDTO:"+boardRequest.toString());
		String path = session.getServletContext().getRealPath("/upload");//세션객체의 경로를 가져온다
		String result="";
		int flag=0;
		if(boardRequest.getMultipartFile().getContentType().equals("application/x-msdownload")) {
			logger.debug("실행파일은 패스");
			flag=1;
			model.addAttribute("flag",flag);
			result="addBoard";
		} else {
			logger.debug("실행파일이 아니니 성공");
			boardService.addBoard(boardRequest,path);
			result="redirect:/";
		}
		return result;
	}

}
