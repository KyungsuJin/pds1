package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao{

	@Autowired
	SqlSessionTemplate sqlSession; //Sqlsession 으로 줄여서 사용가능하게.
	private static final Logger logger = LoggerFactory.getLogger(NoticeDao.class);
	final String NS = "com.test.pds.notice.service.NoticeMapper.";
	
	public int addNotice(Notice notice) {
		logger.debug("NoticeDao.addNotice");
		sqlSession.insert(NS+"intsertNotice",notice);
		int noticeId = notice.getNoticeId(); // int 형 noticeId 안에 notice안의 NoticeId 를 담아준다.
		logger.debug("noticeId : "+notice.getNoticeId());
		return noticeId; //noticeId로 리턴시킨다.
	}
}


