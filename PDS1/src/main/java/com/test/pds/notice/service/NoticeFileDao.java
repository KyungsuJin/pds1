package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeFileDao {
	private static final Logger logger = LoggerFactory.getLogger(NoticeFileDao.class);//LoggerFactory 사용

	final String NS = "com.test.pds.article.service.NoticeFileMapper.";//NS에 주소를 담아줌.
	
	@Autowired SqlSessionTemplate sqlSession;//sqlSession 을 사용가능하게
	
	public void addNoticeFile(NoticeFile noticeFile) {//NoticeFile 을 사용가능하게
		logger.debug("NoticeFileDao.addNoticeFile 메서드 호출");
		sqlSession.insert(NS+"insertNoticeFile", noticeFile);//SqlSession 안의insert 사용한다 
		
	}	
}
