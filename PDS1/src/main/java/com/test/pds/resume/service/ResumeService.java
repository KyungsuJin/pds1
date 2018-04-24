package com.test.pds.resume.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {
	
	@Autowired
	ResumeDao resumeDao;
	private static final Logger logger = LoggerFactory.getLogger(ResumeService.class);
	
	public int addResume(ResumeRequest resumeRequest,String path) {
		MultipartFile multipartFile = resumeRequest.getMultipartFile();

		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString();
		filename = filename.replace("-", " ");
				
		//2. 파일확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		System.out.println("fileExt:"+fileExt);
		
		//3. 파일 컨텐츠 타입
		String fileType = multipartFile.getContentType();
		System.out.println("fileType:" + fileType);
		
		//4. 파일사이즈
		long fileSize = multipartFile.getSize();
		System.out.println("fileSize: "+fileSize);

		//5. 파일 저장(매개변수 path를 이용)
		//File file = new File("d:/upload/"+filename+"."+fileExt);
		
		try {
			File file = new File("D:\\upload\\"+filename+"."+fileExt);
			multipartFile.transferTo(file);
		} catch(IllegalStateException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return dotIndex;
	}
}
