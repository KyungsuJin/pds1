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

import com.test.pds.SystemPath;
import com.test.pds.resume.service.ResumeFile;
import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);
	
	@RequestMapping(value="/updateResumeFile", method= {RequestMethod.POST,RequestMethod.GET})
	public String updateResumeFile(ResumeRequest resumeRequest
									,HttpSession session
									,@RequestParam(value="resumeId") int resumeId) {
		logger.debug("ResumeController - updateResumeFile");
		String path = session.getServletContext().getRealPath("/test");
		resumeService.updateResumeFile(resumeRequest, resumeId, path);
		return "redirect:/getResumeFileDetail";
	}
	
	@RequestMapping(value="/deleteResumeFile", method= {RequestMethod.POST,RequestMethod.GET})
	public String deleteResumeFile(@RequestParam(value="resumeId") int resumeId) {
		logger.debug("ResumeController - deleteResumeFile 리다이렉트 실행.");
		Map<String,Integer> deleteMap = resumeService.deleteResume(resumeId);
		return "redirect:/getResumeList";
	}
	
	@RequestMapping(value="/getResumeFileDetail", method=RequestMethod.GET)
	public String getResumeFile(Model model
								,HttpSession session
							, @RequestParam(value="resumeId") int resumeId) {
		logger.debug("ResumeController - getResumeFile 포워드 실행");	
		ResumeFile resumeFile = resumeService.selectResumeFileOne(resumeId);
		model.addAttribute("resumeFile", resumeFile);
		return "/getResumeFileDetail";
	}
	
	@RequestMapping(value="/getResumeList", method=RequestMethod.GET)
	public String getResumeList(Model model
								,@RequestParam(value="currentPage", defaultValue="1") int currentPage
								,@RequestParam(value="pagePerRow", defaultValue="10")int pagePerRow) {
		logger.debug("ResumeController - getResumeList 포워드 실행");
		Map<String,Object> map = resumeService.selectResumeList(currentPage, pagePerRow);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastBlockPage", map.get("lastBlockPage"));
		model.addAttribute("firstBlockPage", map.get("firstBlockPage"));
		model.addAttribute("totalBlock", map.get("totalBlock"));
		return "getResumeList";
	}
	
	@RequestMapping(value="/addResume", method=RequestMethod.POST)
	public String addResume(ResumeRequest resumeRequest, HttpSession session) {
		logger.debug("ResumeController - addResume 리다이렉트 실행");
		String path = session.getServletContext().getRealPath("resources\\upload");
		logger.debug("path:"+path);
		resumeService.addResume(resumeRequest, path);
		return "redirect:/getResumeList";
	}

	@RequestMapping(value="/addResume", method=RequestMethod.GET)
	public String addResume() {
		logger.debug("ResumeController - addResume 포워드 실행");
		return "addResume";
	}
}