/*package com.test.pds.notice.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {
	private static final Logger logger = LoggerFactory.getLogger(NoticeService.class);//loggerFactory 준비해둔거 사용
	
	private NoticeDao noticeDao; //dao 사용가능하게
	private NoticeFileDao noticeFileDao;//dao 사용가능하게
	
	public void addNotice(NoticeRequest noticeRequest, String path) {//NoticeRequest 사용가능하게, String형 통로
		logger.debug("NoticeService.addNotice 메서드 호출");
		logger.debug("NoticeService.addNotice.noticeRequest : " + noticeRequest.toString());//noticeRequest안의 toString 함수 불러옴.
		logger.debug("NoticeService.addNotice.path : " + path);//noticeservice의 addNotice메서드의 path 는 path다
		List<MultipartFile> multipartFileList = noticeRequest.getMultipartFile();//List 형 MultiartFile 에 noticeRequest안의 getMultipartFile을 넣는다.
		
		Notice notice = new Notice(); //객체생성
		notice.setNoticeTitle(noticeRequest.getNoticetitle());//notice 안에 set 한다 NoticeTitle(NoticeRequest안의 get한다 NoticeTitle을
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		int noticeId = noticeDao.addNotice(notice);// int 형 noticeId 안에 dao안의 addnotice 메서드에서 가져온 값을 넣는다.
		logger.debug("NoticeService.addNotice.noticeId"+noticeId);
		for(MultipartFile multipartFile : multipartFileList) {
			logger.debug("NoticeService.addNotice.multipartFile : "+multipartFile);
			NoticeFile noticeFile = new NoticeFile();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString().replaceAll("-", "");
			logger.debug("NoticeService.addNotice.fileName : "+ noticeId);
			noticeFile.setNoticeFileName(fileName);
			noticeFile.setNoticeFileRealName(multipartFile.getOriginalFilename());
			noticeFile.setNoticeId(noticeId);
			String fileExt = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
			noticeFile.setNoticeFileExt(fileExt);
			noticeFile.setNoticeFileType(noticeFile.getNoticeFileType());
			noticeFile.setNoticeFileSize(noticeFile.getNoticeFileSize());
			File file = new File("D:/upload/"+fileName+"."+fileExt);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		noticeFileDao.addNoticeFile(noticeFile);
	}
		
}
*/