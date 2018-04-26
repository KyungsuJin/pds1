package com.test.pds.resume.controller;

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

import com.test.pds.resume.service.ResumeFile;
import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);
		
	@RequestMapping(value="/deleteResumeFile", method= {RequestMethod.POST,RequestMethod.GET})
	public String deleteResumeFile(@RequestParam(value="resumeId") int resumeId) {
		logger.debug("ResumeController - deleteResumeFile 리다이렉트 실행.");
		Map<String,Integer> deleteMap = resumeService.deleteResume(resumeId);
		return "redirect:/getResumeList";
	}
	
	@RequestMapping(value="/getResumeFileDetail", method=RequestMethod.GET)
	public String getResumeFile(Model model, HttpSession session
							, @RequestParam(value="resumeId") int resumeId) {
		logger.debug("ResumeController - getResumeFile 포워드 실행");	
		ResumeFile resumeFile = resumeService.selectResumeFileOne(resumeId);
		model.addAttribute("resumeFile", resumeFile);
		return "/getResumeFileDetail";
	}
	
	@RequestMapping(value="/getResumeList", method=RequestMethod.GET)
	public String getResumeList(Model model) {
		logger.debug("ResumeController - getResumeList 포워드 실행");
		model.addAttribute("list", resumeService.selectResumeList());
		return "getResumeList";
	}
	
	@RequestMapping(value="/addResume", method=RequestMethod.POST)
	public String addResume(ResumeRequest resumeRequest, HttpSession session) {
		logger.debug("ResumeController - addResume 리다이렉트 실행");
		String path = session.getServletContext().getRealPath("/upload");
		resumeService.addResume(resumeRequest, path);
		return "redirect:/getResumeList";
	}

	@RequestMapping(value="/addResume", method=RequestMethod.GET)
	public String addResume() {
		logger.debug("ResumeController - addResume 포워드 실행");
		return "addResume";
	}
}