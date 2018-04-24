/*package com.test.pds.notice.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticeService {
	private static final logger logger = LoggerFactory.getLogger(NoticeService.class);
	
	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;
	
	public void addNotice(NoticeRequest noticeRequest, String path) {
		logger.debug("NoticeService.addNotice 메서드 호출");
		logger.debug("NoticeService.addNotice.noticeRequest : " + noticeRequest.toString());
		logger.debug("NoticeService.addNotice.path : " + path);
		List<MultipartFile> multipartFileList = noticeRequest.getMultipartFile();
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticetitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		int noticeId = noticeDao.addNotice(notice);
		logger.debug("NoticeService.addNotice.noticeId"+noticeId);
		for(MultipartFile multipartFile : multipartFileList) {
			logger.debug("NoticeService.addNotice.multipartFile : "+multipartFile);
		}
		
		
	}
		
}
*/