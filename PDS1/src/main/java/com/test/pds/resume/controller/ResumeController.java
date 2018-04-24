package com.test.pds.resume.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	ResumeService resumeService;
	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);
	
	@RequestMapping(value="/addResume", method=RequestMethod.POST)
	public String boardAdd(ResumeRequest resumeRequest, HttpSession request) {

	String Path = request.getServletContext().getRealPath("/resources/upload");
	logger.info("realPath: "+Path);
	resumeService.addResume(resumeRequest, Path);
	return "redirect:/";
	}

	@RequestMapping(value="/addResume", method=RequestMethod.GET)
	public String addResume() {
		logger.info("ResumeController - addResume 포워드 실행");
		return "/addResume";
	}
	
}
