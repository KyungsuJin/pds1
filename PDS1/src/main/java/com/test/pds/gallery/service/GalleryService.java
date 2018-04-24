package com.test.pds.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class GalleryService {
	
	@Autowired
	GalleryDao galleryDao;
	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	public List<Gallery> getGalleryList() {
		logger.debug("GalleryService_getGalleryList");
		return galleryDao.getGalleryList();
	}
	
	public int addGallery(GalleryRequest galleryRequest, String path) {
		logger.debug("GalleryService_addGallery");
		MultipartFile multipartFile = galleryRequest.getMultipartFile();
		logger.debug(multipartFile+"<--multipartFile");
		logger.debug(path+"<--path");
		
		Gallery gallery = new Gallery();
		GalleryFile galleryFile = new GalleryFile();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());

		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString().replaceAll("-", "");
		logger.debug("fileName : "+fileName);
		galleryFile.setGalleryFileName(fileName);
		
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		logger.debug("dotIndex : "+dotIndex);	
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		logger.debug("fileExt : "+fileExt);
		galleryFile.setGalleryFileExt(fileExt);
		
		String fileType = multipartFile.getContentType();
		logger.debug("fileType : "+fileType);
		galleryFile.setGalleryFileType(fileType);
		
		long fileSize = multipartFile.getSize();
		logger.debug("fileSize : "+fileSize);
		galleryFile.setGalleryFileSize(fileSize);
		
		gallery.setGalleryFile(galleryFile);
		File file = new File("d:/upload/"+fileName+"."+fileExt);
		logger.debug("file : "+file);
		
		try {
			multipartFile.transferTo(file);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return galleryDao.addGallery(gallery);
	}
}
