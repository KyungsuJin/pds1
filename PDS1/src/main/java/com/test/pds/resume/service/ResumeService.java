package com.test.pds.resume.service;

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
public class ResumeService {
	
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ResumeFileDao resumeFileDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ResumeService.class);
	
	public void addResume(ResumeRequest resumeRequest, String path) {
		
	List<MultipartFile> multipartFileList = resumeRequest.getMultipartFile();
		
		Resume resume = new Resume();
		resume.setResumeTitle(resumeRequest.getResumeTitle());
		resume.setResumeContent(resumeRequest.getResumeContent());
		
		resumeDao.addResume(resume);
		
		//multipartFile -> articleFile
		for(MultipartFile multipartFile : multipartFileList) {
			ResumeFile resumeFile = new ResumeFile();
			UUID uuid = UUID.randomUUID();
			String filename = uuid.toString();
			filename = filename.replace("-", " ");
			resumeFile.setResumeFileName(filename);
			//2. 파일확장자
			int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
			String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
			System.out.println("fileExt:"+fileExt);
			resumeFile.setResumeFileExt(fileExt);
			
			//3. 파일 컨텐츠 타입
			String fileType = multipartFile.getContentType();
			System.out.println("fileType:" + fileType);
			resumeFile.setResumeFileType(fileType);
			
			//4. 파일사이즈
			long fileSize = multipartFile.getSize();
			System.out.println("fileSize: "+fileSize);
			resumeFile.setResumeFileSize(fileSize);
			
			File file = new File("d:\\upload\\"+filename+"."+fileExt);
			try {
				 multipartFile.transferTo(file);
			} catch(IllegalStateException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			resumeFileDao.addResumeFile(resumeFile);
		}
	}
}