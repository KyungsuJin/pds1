/*package com.test.pds.notice.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;


@Controller
public class NoticeController {//controller 
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);//loggerFactory로 미리 만들어둔것 사용가능
	
	@Autowired NoticeService noticeService;//noticeService사용가능하게 만듬.
	
	@RequestMapping(value="/addNotice",method=RequestMethod.GET)//get방식으로 값 불러와서 사용해준다. addNotice로 보낸다
	public String addNotice() {
		return "addNotice";
	}
	@RequestMapping(value="/addNotice",method=RequestMethod.POST)//post방식으로 값을 받아와 사용한다.
	public String addNotice(NoticeRequest noticeRequest, HttpSession session) { //NoticeRequest 사용가능하게, Session 사용가능하게
		System.out.println(noticeRequest.toString());//noticeRequest 안의 toString 메서드를 들어왔는지 보여줌.
		String path = session.getServletContext().getRealPath("/upload");//upload 폴더의 경로를 불러와줌.
		noticeService.addNotice(noticeRequest, path);//noticeService 의  addNotice 메서드를 찾아간다.
		
		return"redirect:/"; // /으로 리다이렉트 시킨다.
		
	}
}
*/