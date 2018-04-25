package com.test.pds.gallery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.pds.gallery.service.GalleryRequest;
import com.test.pds.gallery.service.GalleryService;


@Controller
public class GalleryController {
	@Autowired
	GalleryService galleryService;
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@RequestMapping(value="getGalleryList", method=RequestMethod.GET)
	public String getGalleryList(Model model) {
		logger.debug("GalleryController_getGalleryList");
		model.addAttribute("list",galleryService.getGalleryList());
		return "getGalleryList";
	}
	@RequestMapping(value="addGallery", method=RequestMethod.GET)
	public String addGallery() {
		logger.debug("GalleryController_addGallery_GET");
		return "addGallery";
	}
	@RequestMapping(value="addGallery", method=RequestMethod.POST)
	public String addGallery(Model model, GalleryRequest galleryRequest, HttpSession session) {
		logger.debug("GalleryController_addGallery_POST");
		String path = session.getServletContext().getRealPath("/upload");
		galleryService.addGallery(galleryRequest, path);
		
		///유효성검사
		/*boolean flag = true;		
		if(galleryRequest.getMultipartFile().getContentType().equals("image/gif") 
				|| galleryRequest.getMultipartFile().getContentType().equals("image/jpeg")
				|| galleryRequest.getMultipartFile().getContentType().equals("image/png")) {
			logger.debug("업로드가능한 파일입니다.");
			galleryService.addGallery(galleryRequest, path);
			return "redirect:/";
		}
			logger.debug("업로드가 불가능한 파일입니다.");
			model.addAttribute("flag", flag=false);*/
		return "addGallery";
	}
}