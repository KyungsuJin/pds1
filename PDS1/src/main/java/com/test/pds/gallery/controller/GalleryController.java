package com.test.pds.gallery.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String addGallery(GalleryRequest galleryRequest, HttpSession session) {
		logger.debug("GalleryController_addGallery_POST");
		String path = session.getServletContext().getRealPath("/upload");
		galleryService.addGallery(galleryRequest, path);
		return "redirect:/";
	}
}
