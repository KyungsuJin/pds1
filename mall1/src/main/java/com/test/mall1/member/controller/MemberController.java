package com.test.mall1.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getMemberList(Model model
								, @RequestParam(value="currentPage", defaultValue="1") int currentPage
								, @RequestParam(value="pagePerRow", defaultValue="10") int pagePerRow) {
		logger.info("MemberController 의 getMemberList GET 메서드 실행");
		Map<String, Object> map = memberService.selectMemberList(currentPage, pagePerRow);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("beforePage", map.get("beforePage"));
		model.addAttribute("nextPage", map.get("nextPage"));
		return "getMemberList";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, Member member, HttpSession session) {
		Member returnMember = memberService.getMemberById(member);
		if(returnMember == null) {
			model.addAttribute("requestMember", member);
			return "index";
		}
		session.setAttribute("sessionMemberId", returnMember.getMemberId());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String login(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
