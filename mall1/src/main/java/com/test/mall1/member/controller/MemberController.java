package com.test.mall1.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "addMember";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(Member member) {
		memberService.addMember(member);
		return "redirect:/";
	}
}
