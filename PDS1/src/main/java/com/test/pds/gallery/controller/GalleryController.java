package com.test.pds.gallery.controller;

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

import com.test.pds.gallery.service.Gallery;
import com.test.pds.gallery.service.GalleryRequest;
import com.test.pds.gallery.service.GalleryService;


@Controller
public class GalleryController {
	@Autowired
	GalleryService galleryService;
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@RequestMapping(value="modifyGallery", method=RequestMethod.GET)
	public String modifyGallery(Model model,@RequestParam(value="galleryId") int galleryId) {
		logger.debug("GalleryController_modifyGallery");
		Gallery gallery = galleryService.selectGalleryDetail(galleryId);
		model.addAttribute("gallery", gallery);
		return "modifyGallery";
	}
	@RequestMapping(value="modifyGallery", method=RequestMethod.POST)
	public String modifyGallery() {
		//galleryService.modifyGalleryPro(gallery);
		return "galleryDetail";
	}
	@RequestMapping(value="removeGallery", method=RequestMethod.GET)
	public String removeGallery(int galleryId) {
		galleryService.removeGallery(galleryId);
		return "redirect:getGalleryList";
	}
	@RequestMapping(value="galleryDetail", method=RequestMethod.GET)
	public String selectGalleryDetail(Model model
										,@RequestParam(value="galleryId") int galleryId) {
		logger.debug("GalleryController_galleryDetail");
		Gallery gallery = galleryService.selectGalleryDetail(galleryId);
		model.addAttribute("gallery", gallery);
		return "galleryDetail";
	}
	
	@RequestMapping(value="getGalleryList", method=RequestMethod.GET)
	public String getGalleryList(Model model
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10") int pagePerRow) {
		logger.debug("GalleryController_getGalleryList");
		Map<String, Object> returnMap=galleryService.getGalleryList(currentPage, pagePerRow);
		model.addAttribute("list", returnMap.get("list"));
		model.addAttribute("currentPage", returnMap.get("currentPage"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("endPage", returnMap.get("endPage"));
		model.addAttribute("startPage", returnMap.get("startPage"));
		model.addAttribute("flag", returnMap.get("flag"));
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
		String path = session.getServletContext().getRealPath("resources/upload/");
		logger.debug(galleryRequest.getMultipartFile().size()+"사이즈몇이냐");
		///유효성검사
		boolean flag = true;
		
		for(int i=0; i<galleryRequest.getMultipartFile().size(); i++) {
			logger.debug("GalleryController_addGallery_for문");
			if(!galleryRequest.getMultipartFile().get(i).getContentType().equals("image/gif") 
					&& !galleryRequest.getMultipartFile().get(i).getContentType().equals("image/jpeg")
					&& !galleryRequest.getMultipartFile().get(i).getContentType().equals("image/png")) {
				logger.debug(i+"번째 파일 업로드가 불가능한 파일입니다.");
				model.addAttribute("flag", flag=false);
				return "addGallery";
			}else {
				logger.debug(i+"번째 파일 업로드가능한 파일입니다.");	
			}
		}		
		galleryService.addGallery(galleryRequest, path);
		return "redirect:/";								
	}
}
