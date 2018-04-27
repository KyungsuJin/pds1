package com.test.pds.notice.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;//import 는 다른 곳에서 패키지 선언 안해주기 위해서 쓴다.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;

@Controller //컨트롤러 어노테이션은 컨트롤러 라는 것을 명시하기 위해쓴다.
public class NoticeController{
	@Autowired
	NoticeService noticeService; //선언해준다 밑에서 사용하기위해서
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);	//LoggerFactory로 세팅된것 사용
	@RequestMapping(value ="addNotice",method=RequestMethod.GET)	//addnotice값을 get 방시으로 받아온다.
	public String addNotice() {	//리턴타입이 String 형인 addnotice
		logger.debug("NoticeController addNotice GET");	//debug 등급의 로거 작성
		return addNotice();	//addnotice로 포워딩
		
	}
	@RequestMapping(value="addNotice",method=RequestMethod.POST)
	public String addNotice(Model model,NoticeRequest noticeRequest, HttpSession session) {
		logger.debug("NoticeController addNotice POST");
		logger.debug("NoticeDto : "+ noticeRequest.toString());
		String path = session.getServletContext().getRealPath("/upload");	//업로드할파일의 실제경로를 받아온다.
		int flag=0;		//int 형 flag는 0이라고 초기화
		for(MultipartFile multipartFile : noticeRequest.getMultipartFile()) {	//c:for 문이라는데 잘 모르겠음.
			if(multipartFile.getContentType().equals("application/x-msdownload")) {
				//"application/x-msdownload" 가 실행파일의 확장자명을 나타내는건 알겠는데 왜 저렇게 표현하는지는 잘 모르겠다.
				logger.debug("실행파일은 업로드불가");
				flag=1;
				model.addAttribute("flag", flag);//model이용해서 flag 에 1 주입한것을 addNotice로 보내서 실행파잉은 올릴 수 없다고 보여준다.
				return "addNotice";
			}
		}
		logger.debug("실행파일이 아니기 때문에 성공했습니다.");
		noticeService.addNotice(noticeRequest,path); //noticeService안의 addNotice 메서드 안의 path를 요청한다.
		return "redirect:/"; // 리다이렉트 시킨다 / 의 경로로
		
	}
}