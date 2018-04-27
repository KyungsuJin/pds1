package com.test.pds.notice.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeFileDao{
	@Autowired
	SqlSessionTemplate sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(NoticeFileDao.class); 
	final String NS = "com.test.pds.notice.service.NoticeFileMapper."; //NS로 줄여서씀
	
	public void addNoticeFile(Map<String,Object>map) { //Map 을 사용 가능하게 해주고, key 값은 String 형 값은 Object(모든형식)형으로 되어있다.
		logger.debug("NoticeFileDao.addNoticeFile");
		sqlSession.insert(NS+"addNoticeFile",map);
	}
}