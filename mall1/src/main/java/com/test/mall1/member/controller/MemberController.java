package com.test.mall1.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall1.IndexController;
import com.test.mall1.member.service.Member;
import com.test.mall1.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/addMember", method = RequestMethod.GET)
	public String addMember() {
		logger.info("MemberController 의 addMember GET 메서드 실행");
		return "addMember";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(Member member) {
		logger.info("MemberController 의 addMember POST 메서드 실행");
		memberService.addMember(member);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	public String getMemberList(Model model) {
		logger.info("MemberController 의 getMemberList GET 메서드 실행");
		List<Member> list = memberService.selectMemberList();
		model.addAttribute("list", list);
		return "getMemberList";
	}
	
	
	
	@RequestMapping(value="/getMember", method=RequestMethod.GET)
	public String getMember(Model model, HttpSession session) {
		/*
		service 호출 -> repository 호출 
		service 리턴 <- repository 리턴
		return : "jjdev"
		request.setAttribute("name", "jjdev");
		view(jsp) : ${name}
		*/
		//String name = memberService.getMember();
		//model.addAttribute("name", name);
		
		return "getMember";
	}
	
	
}
