package com.test.pds.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.board.service.Board;
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
		int flag=0;
		for(MultipartFile multipartFile : boardRequest.getMultipartFile()) {
			if(multipartFile.getContentType().equals("application/x-msdownload")) {
				logger.debug("실행파일은 패스");
				flag=1;
				model.addAttribute("flag",flag);
				return "addBoard";
			}
		}
		logger.debug("실행파일이 아니니 성공");
		boardService.addBoard(boardRequest,path);
		
		return "redirect:/";
	}
	@RequestMapping(value="getBoardList",method=RequestMethod.GET)
	public String getBoardList(Model model) {
		logger.debug("boardController.getBoardList");
		List<Board> list=boardService.getBoardList();
		model.addAttribute("list",list);
		return "getBoardList";
	}

}
