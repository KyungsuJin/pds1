package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	private static final Logger logger = LoggerFactory.getLogger(NoticeDao.class);//LoggerFactory 사용가능하게 해줌.
	
	@Autowired private SqlSessionTemplate sqlSession;//sqlTemplate 사용가능하게 
	final String NS = "com.test.pds.notice.service.NoticeMapper.";//NS 에 주소를 넣어줌
	public int addNotice(Notice notice) {//인트형 addNotice 에 Notice사용가능하게
		logger.debug("NoticeDao.addNotice 메서드호출");
		sqlSession.insert(NS + "insertNotice", notice);//SqlSession안의 insert를 실행  
		return notice.getNoticeId();//notice메서드 안의 noticeId를 get 해서 리턴시킨다.
	}
}
