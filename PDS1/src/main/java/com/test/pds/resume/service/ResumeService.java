package com.test.pds.resume.service;

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

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;

 

import com.test.pds.SystemPath;

@Service
@Transactional
public class ResumeService {
	
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeFileDao resumeFileDao;
	private static final Logger logger = LoggerFactory.getLogger(ResumeService.class);

	public Map<String, Object> updateResumeFile(ResumeRequest resumeRequest,int resumeId, String path) {
		int resumeFiledelete = 0;
			resumeFiledelete = resumeFileDao.deleteResumeFile(resumeId);
		if(resumeFiledelete > 0) {
			MultipartFile multipartFile = resumeRequest.getMultipartFile();
			
			//multipartFile -> resumeFile
			ResumeFile resumeFile = new ResumeFile();
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString().replaceAll("-", " ");
			logger.debug("filename:"+filename);
			resumeFile.setResumeFileName(filename);
			String fileRealName = multipartFile.getOriginalFilename();
			logger.debug("fileRealName:"+fileRealName);
			resumeFile.setResumeFileRealName(fileRealName);
			
			//2. 파일확장자
			int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
			String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
			logger.debug("fileExt:"+fileExt);
			resumeFile.setResumeFileExt(fileExt);
			
			//3. 파일 컨텐츠 타입
			String fileType = multipartFile.getContentType();
			logger.debug("fileType:" + fileType);
			resumeFile.setResumeFileType(fileType);
			
			//4. 파일사이즈
			long fileSize = multipartFile.getSize();
			logger.debug("fileSize: "+fileSize);
			resumeFile.setResumeFileSize(fileSize);
			
			resumeFile.setResumeId(resumeId);
			
			File file = new File(SystemPath.DOWNLOAD_PATH+filename+"."+fileExt);
			
			try {
				 multipartFile.transferTo(file);
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			resumeFileDao.addResumeFile(resumeFile);
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("delete", resumeFiledelete);
		return returnMap;
	}
	
	public Map<String, Integer> deleteResume(int resumeId) {
	int resumeFiledelete = 0;
	resumeFiledelete = resumeFileDao.deleteResumeFile(resumeId);
	int resumedelete = 0;
	if(resumeFiledelete>0){
		resumedelete = resumeDao.deleteResume(resumeId);
	}
	Map<String,Integer> deleteMap = new HashMap<String,Integer>();
	deleteMap.put("resumeFiledelete", resumeFiledelete);
	deleteMap.put("resumedelete", resumedelete);
	return deleteMap;
	}

	public ResumeFile selectResumeFileOne(int resumeId) {
		logger.debug("ResumeService - selectResumeFileOne 실행");
		return resumeFileDao.selectResumeFile(resumeId);
	}
	
	public  Map<String, Object> selectResumeList(int currentPage, int pagePerRow) {
		logger.debug("ResumeService - selectResume 실행");
		Map<String,Integer> map = new HashMap<String,Integer>();
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Resume> list = resumeDao.selectResume(map);
		int totalResumeCount = resumeDao.resumeCount();
		int lastPage = totalResumeCount/pagePerRow;
        if(totalResumeCount % pagePerRow != 0) {
            lastPage++;
        }
        logger.debug("list:"+list);
        logger.debug("lastPage:"+lastPage);
        logger.debug("currentPage:"+currentPage);
        logger.debug("beginRow:"+beginRow);
        logger.debug("pagePerRow:"+pagePerRow);
        logger.debug("======================page block=========================");
       
        int pagePerBlock = 10; //보여줄 블록 수 
        int block = currentPage/pagePerBlock;
        int totalBlock = totalResumeCount/pagePerBlock;//총 블록수
        
        if(currentPage % pagePerBlock != 0) {
        	block ++;
        }
        int firstBlockPage = (block-1)*pagePerBlock+1;
        int lastBlockPage = block*pagePerBlock;
        
		if(lastPage > 0) {			
			if(lastPage % pagePerBlock != 0) {
				totalBlock++;
			}
		}
		if(lastBlockPage >= totalBlock) {
			lastBlockPage = totalBlock;
		}
		logger.debug("firstBlockPage:"+firstBlockPage);
		logger.debug("lastBlockPage:"+lastBlockPage);
		logger.debug("block:"+block);
		logger.debug("totalBlock:"+totalBlock);
		logger.debug("======================page block=========================");
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("firstBlockPage", firstBlockPage);
		returnMap.put("lastBlockPage", lastBlockPage);
		returnMap.put("totalBlock", totalBlock);
		return returnMap;
	}
	
	public void addResume(ResumeRequest resumeRequest, String path) {
			MultipartFile multipartFile = resumeRequest.getMultipartFile();
			logger.debug("ResumeService - addResume 실행");
			Resume resume = new Resume();
			String resumeTitle = resumeRequest.getResumeTitle();
			String resumeContent = resumeRequest.getResumeContent(); 
			resume.setResumeTitle(resumeTitle);
			resume.setResumeContent(resumeContent);
			logger.debug("resumeTitle: "+resumeTitle);
			logger.debug("resumeContent: "+resumeContent);
			int resumeId = resumeDao.addResume(resume);		
			
			//multipartFile -> resumeFile
			ResumeFile resumeFile = new ResumeFile();
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString().replaceAll("-", " ");
			logger.debug("filename:"+filename);
			resumeFile.setResumeFileName(filename);
			String fileRealName = multipartFile.getOriginalFilename();
			logger.debug("fileRealName:"+fileRealName);
			resumeFile.setResumeFileRealName(fileRealName);
			
			//2. 파일확장자
			int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
			String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
			logger.debug("fileExt:"+fileExt);
			resumeFile.setResumeFileExt(fileExt);
			
			//3. 파일 컨텐츠 타입
			String fileType = multipartFile.getContentType();
			logger.debug("fileType:" + fileType);
			resumeFile.setResumeFileType(fileType);
			
			//4. 파일사이즈
			long fileSize = multipartFile.getSize();
			logger.debug("fileSize: "+fileSize);
			resumeFile.setResumeFileSize(fileSize);
			
			resumeFile.setResumeId(resumeId);
			
			File file = new File(SystemPath.DOWNLOAD_PATH+filename+"."+fileExt);
			
			try {
				 multipartFile.transferTo(file);
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			
			resumeFileDao.addResumeFile(resumeFile);
			logger.debug("ResumeService - addResume - resumeFileDao 실행");
	}
}