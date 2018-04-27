package com.test.pds.notice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service //서비스 라는 것을 명시해준다.
@Transactional  // 트렌잭션처리 메서드 하나가 실행되고 다음것도 실행되야 하는데 하나만 실행되고 두번쨰 것이 실패 했을떄 전체를 취소해 주기 위해 쓰는 것이다.
public class NoticeService {
	@Autowired
	NoticeDao noticeDao;//noticeDao 에 있는 메서드 들을 끌어와서 사용하기 위해서 오토와이어드 해주었다.
	@Autowired
	NoticeFileDao noticeFileDao;
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeService.class);
	//private 로 다른 메서드에서 사용 불가능하게 해준다. final로 수정불가능 걸어주고 logger 선언해주고 그안에 이미 설정파일에서 설정된 
	//LoggerFactory안에 NoticeService의 클래스를 get해서 넣어준다.
	public void addNotice(NoticeRequest noticeRequest, String path) { //NoticeRequest 를 사용하기 위해서 선언해주고,path는 나중에 더 알아봐야할듯.
		logger.debug("NoticeService.addNotice");
		List<MultipartFile> multipartFileList = noticeRequest.getMultipartFile();
		logger.debug("multipartFile : "+multipartFileList );
		logger.debug("path : "+path);
		
		Notice notice = new Notice(); //Notice 객체 생성해준다.
		ArrayList<NoticeFile> noticeFilelist = new ArrayList<NoticeFile>();//ArrayList 형 NoticeFile 을 객체생성 해준다.
		notice.setNoticeTitle(noticeRequest.getNoticetitle()); //notice안의 NoticeTitle 에 Noticetitle을 get 요청한다.
		notice.setNoticeContent(noticeRequest.getNoticeContent()); //notice안의 NoticeContent에 NoticeContent를 get 요청한다.
		int noticeId=noticeDao.addNotice(notice); //int 형 noticeId 안에 noticeDao 안의 addNotice 메서드의 notice값을 담는다.
		for(MultipartFile multipartFile: multipartFileList) {
			NoticeFile noticeFile = new NoticeFile(); //객체생성
			noticeFile.setNoticeFileId(noticeId);
			UUID uuid = UUID.randomUUID(); // 랜덤한 id 값을 생성해서 uuid 에 담는다.
			String fileName = uuid.toString().replaceAll("-", ""); // String 형 fileName에 uuid안의 toString 메서드의 -를 전부 공백으로 바꾼다.
			logger.debug("noticeFile.setNoticeFileName:"+fileName);
			noticeFile.setNoticeFileName(fileName); //noticefile 안에 NoticeFilename 의 filename을 담는다.
			
			String name = multipartFile.getOriginalFilename();
			logger.debug("debug:"+name);
			
			int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
			logger.debug("dotIndex : "+name);
			
			String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
			logger.debug("noticeFile.setNoticeFileExt : "+fileExt);
			/*noticeFile.setNoticeFileExt(FileExt);*/
			
		}
	}
}