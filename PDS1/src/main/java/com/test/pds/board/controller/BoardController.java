package com.test.pds.board.controller;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.board.service.Board;
import com.test.pds.board.service.BoardFile;
import com.test.pds.board.service.BoardRequest;
import com.test.pds.board.service.BoardService;
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
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
		String path = session.getServletContext().getRealPath("resources/upload");//세션객체의 경로를 가져온다
		int flag=0;
		//for 문을 이용해 controller 넘어온 파일들을 if 문을 사용해 검사한다
		for(MultipartFile multipartFile : boardRequest.getMultipartFile()) {
			//만약 파일의 type 이 application/x-msdownload 와 같다면 flag 를 1로바꾸고 flag 를 셋팅
			if(multipartFile.getContentType().equals("application/x-msdownload")) {
				logger.debug("실행파일은 패스");
				flag=1;
				model.addAttribute("flag",flag);
				return "addBoard";
			}
		}
		logger.debug("실행파일이 아니니 성공");
		boardService.addBoard(boardRequest,path);
		return "redirect:/getBoardList";
	}
	@RequestMapping(value="getBoardList",method=RequestMethod.GET)
	public String getBoardList(Model model
							,@RequestParam(value="currentPage",defaultValue="1")int currentPage
							,@RequestParam(value="pagePerRow",defaultValue="10")int pagePerRow) {
		logger.debug("boardController.getBoardList");
		Map<String,Object> map =boardService.getBoardList(currentPage,pagePerRow);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("startPage",map.get("startPage"));
		model.addAttribute("endPage",map.get("endPage"));
		model.addAttribute("lastPage",map.get("lastPage"));
		model.addAttribute("currentPage",currentPage);
		return "getBoardList";
	}
	@RequestMapping(value="getBoardContent",method=RequestMethod.GET)
	public String getDetailList(Model model
								,@RequestParam(value="boardId")int boardId) {
		logger.debug("boardController.getDetailList : "+boardId);
		List<Board> list =boardService.getDetailList(boardId);
		
		model.addAttribute("list",list);
		return "getBoardContent";
	}
	@RequestMapping(value="modifyBoard",method=RequestMethod.GET)
	public String modifyBoard(Model model
							,@RequestParam(value="boardId")int boardId) {
		List<Board> list =boardService.getDetailList(boardId);
		
		model.addAttribute("list",list);
		return "modifyBoard";
	}
	@RequestMapping(value="modifyBoard",method=RequestMethod.POST)
	public String modifyBoard(Model model
							,BoardRequest boardRequest) {
		boardService.modifyBoard(boardRequest);
		return "redirect:/getBoardList";
	}

}
