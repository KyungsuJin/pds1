package com.test.pds.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	@Autowired
	GalleryFileDao galleryFileDao;
	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	public Map<String, Object> selectGalleryDetail(int galleryId) {
		logger.debug("GalleryService_selectGalleryDetail");
		logger.debug("111111111111111111111111111galleryId : "+galleryId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gallery", galleryDao.selectGalleryDetail(galleryId));
		map.put("list", galleryFileDao.selectFileList(galleryId));
		return map;
	}
	public Map<String, Object> getGalleryList(int currentPage, int pagePerRow) {
		logger.debug("GalleryService_getGalleryList");
		logger.debug("currentPage : "+currentPage);
		logger.debug("pagePerRow : "+pagePerRow);
		int totalCount = galleryDao.totalCount(); // 전체 게시글수
		logger.debug("totalCount : "+totalCount);
		int lastPage = totalCount/pagePerRow; // 몇페이지인지 구한다.
		if(totalCount%pagePerRow != 0) {
			lastPage++;
			//만약 51개의 게시글을 10개씩 pagePerRow 한다면 6페이지가되야함으로 1을 더해준다.
		}
		logger.debug("lastPage : "+lastPage);
		int beginRow = (currentPage-1)*pagePerRow; 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		
		List<Gallery> list = galleryDao.getGalleryList(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("currentPage", currentPage);
		returnMap.put("lastPage", lastPage);
		
		int pageCount = 10; //하단에 표시되는 페이지의 숫자
		int endPage = (int)(Math.ceil(currentPage/(double)pageCount)*pageCount);
		/*
		 * 10개씩 보여주기때문에 끝페이지는 무조껀 10 20 30 40으로 떨어져야한다.
		 * 현재페이지가 2,3,4,5,6,7,8,9 일때도 무조껀 endPage는 10이되야되기때문에 
		 * currentPage에 pageCount값을 나눠서 반올림을 해주었다.
		 */
		logger.debug("endPage : "+endPage);
		int startPage = (endPage-pageCount)+1;
		/*
		 * pageCount가 10이므로
		 * startPage는 항상 1, 11, 21, 31이되어야한다.
		 */
		logger.debug("startPage : "+startPage);
		int endPage2 = (int)(Math.ceil(totalCount/(double)pagePerRow));
		boolean flag = true; // 다음버튼을 비활성화 시키기위한 flag
		
		if(endPage*pagePerRow >= totalCount) { //다음버튼을 없애기위한 flag
			flag = false;
		}
		if(endPage>endPage2) { // 항상 endPage는 10이상 나온다 그러므로 게시물이 적거나 없을때를 위한 if문
			endPage = endPage2;
		}
		logger.debug("endPage2 : "+endPage);
		
		returnMap.put("endPage", endPage);
		returnMap.put("startPage", startPage);
		returnMap.put("flag", flag);
		
		return returnMap;
	}
	public int addGallery(GalleryRequest galleryRequest, String path) {
		List<MultipartFile> list = galleryRequest.getMultipartFile();
		
		Gallery gallery = new Gallery();
		GalleryFile galleryFile = new GalleryFile();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());
		
		for(MultipartFile multipartFile:list) {
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().replaceAll("-", "");
			logger.debug("fileName : "+fileName);
			galleryFile.setGalleryFileName(fileName);
			
			String fileRealName = multipartFile.getOriginalFilename();
			logger.debug("fileRealName : "+fileRealName);
			galleryFile.setGalleryFileRealName(fileRealName);
			
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
			int galleryId = galleryDao.addGallery(gallery);
			galleryFile.setGalleryId(galleryId);
			
			try {
				multipartFile.transferTo(file);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			galleryFileDao.addGalleryFile(galleryFile);
		}
		return 0;
	}
}
