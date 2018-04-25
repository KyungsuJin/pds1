package com.test.pds.resume.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartException;
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
	
	public String selectResumeFileOne() {
		logger.debug("ResumeService - selectResumeFileOne 실행");
		return null;
	}
	
	public List<Resume> selectResumeList() {
		logger.debug("ResumeService - selectResume 실행");
		List<Resume> list = resumeDao.selectResume();
		return list;
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