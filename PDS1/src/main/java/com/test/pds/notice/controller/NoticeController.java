/*package com.test.pds.notice.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;


@Controller
public class NoticeController {//controller 을 사용하기 위해 
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);//loggerFactory로 미리 만들어둔거 사용
	
	@Autowired NoticeService noticeService;//noticeService를 사용하기위해
	
	@RequestMapping(value="/addNotice",method=RequestMethod.GET)//get방식으로 addNotice를 받아와서 사용
	public String addNotice() {
		return "addNotice";
	}
	@RequestMapping(value="/addNotice",method=RequestMethod.POST)//post방식 이하동문
	public String addNotice(NoticeRequest noticeRequest, HttpSession session) { //NoticeRequest 를 생성하고 , Session 사용가능하게
		System.out.println(noticeRequest.toString());//noticeRequest 값 제대로 들어왓는지봄.
		String path = session.getServletContext().getRealPath("/upload");//upload라는 곳에 위치시키기위한것
		noticeService.addNotice(noticeRequest, path);//noticeService안의 addNotice로 가서  그뒤는 잘 모르겠음.
		
		return"redirect:/"; // /이라는 주소로 리다이렉트
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET) //get방식으로  /값을 받아옴
	public String home(Locale locale, Model model) { // locale , Model 함수 사용하기위해
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date(); // Date객체생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);//잘모르겠음.
		
		String formattedDate = dateFormat.format(date); // String 형 formattedDate 안에 dateFormat안의 format(date) 값을 담아준다
		
		model.addAttribute("serverTime", formattedDate ); //model안의 addAttribute 활용하여 key값 serverTime, 값 formattedDate 를담아준다.
		
		return ""; // 포워딩한다. 아직 jsp 안만들었다.
	}
	
}
*/