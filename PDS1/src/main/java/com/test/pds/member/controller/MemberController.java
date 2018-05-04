package com.test.pds.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.test.pds.member.service.Member;
import com.test.pds.member.service.MemberService;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value="addMember",method=RequestMethod.GET)
	public String addMember() {
		logger.debug("MemberController.addMember GET");
		return "addMember";
	}
	
	@RequestMapping(value="addMember",method=RequestMethod.POST)
	public String addMember(HttpSession session, Member member) {
		logger.debug("MemberController.addMember POST");
		memberService.addMember(member);
		return "redirect:/";
	}

	@RequestMapping(value="memberIdCheckForm",method=RequestMethod.GET)
	public String memberIdCheckForm() {
		logger.debug("MemberController.memberIdCheckForm GET");
		return "memberIdCheckForm";
	}
	
	@RequestMapping(value="memberIdCheckForm",method=RequestMethod.POST)
	public String memberIdCheckForm(Model model, Member member) {
		logger.debug("MemberController.memberIdCheckForm POST");
		model.addAttribute("member", member);
		model.addAttribute("returnMember", memberService.memberIdCheck(member));
		return "memberIdCheckForm";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		logger.debug("MemberController.login GET");
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model model, Member member, HttpSession session) {
		logger.debug("MemberController.login POST");
		if(memberService.loginMember(member)) {
			session.setAttribute("sessionMemberId", member.getMemberId());
			return "redirect:/";
		}
		model.addAttribute("member", member);
		return "login";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.debug("MemberController.logout GET");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="getMemberList",method=RequestMethod.GET)
	public String getMemberList(Model model
				,@RequestParam(value="currentPage", defaultValue="1" ) int currentPage
				,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("MemberController.getMemberList GET");
		
		Map map = memberService.getMemberList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("firstPage", map.get("firstPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("beforePage", map.get("beforePage"));
		model.addAttribute("afterPage", map.get("afterPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "getMemberList";
	}
	
	@RequestMapping(value="/removeMember", method=RequestMethod.GET)
	public String removeMember(Member member
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("MemberController.removeMember GET 방식 호출");
		memberService.removeMember(member);
		return "redirect:/getMemberList?currentPage=" + currentPage + "&pagePerRow=" + pagePerRow;
	}
	
	@RequestMapping(value="/modifyMember", method=RequestMethod.GET)
	public String modifyMember(Model model
									,Member member
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("MemberController.modifyMember GET 방식 호출");
		model.addAttribute("member", memberService.getMemberInfo(member));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "modifyMember";
	}
	
	@RequestMapping(value="/modifyMember", method=RequestMethod.POST)
	public String modifyMember(Member member
									,HttpSession session
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10" ) int pagePerRow) {
		logger.debug("MemberController.modifyMember GET 방식 호출");
		memberService.modifyMember(member);
		if(session.getAttribute("sessionMemberId").equals("admin")) {
			return "redirect:/getMemberList?currentPage=" + currentPage + "&pagePerRow=" + pagePerRow;
		} else {
			return "redirect:/";
		}
		
	}
}
