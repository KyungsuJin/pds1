package com.test.pds.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class NoticeController {//controller 어노테이션 사용해서 컨트롤러 기능 사용하게 해준다.
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);//private 로 class밖에서 사용 불가능하게 해준다. final 써서 수정불가능하게 해준다.
	// logger 선언하고 loggerFactory 안에 logger 를 겟 해와서 NoticeController안의 클래스를  불러온다.
	
	public String addNotice() { // String 형 리턴값을 가지는 addNotice 메서드
		logger.debug("NoticeController.addNotice 메서드 호출"); //debug 등급으로 보여줘서 개발자에게만 보여주게 한다. 나중에는 info 등급만 보이게 하면
		// 유저등에게는 안보인다. 
		return "addNotice"; // addNotice 로 포워딩 해준다.
	}
	
}
