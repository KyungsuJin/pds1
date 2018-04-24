package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository
public class ResumeFileDao {
	private static final Logger logger = LoggerFactory.getLogger(ResumeFileDao.class);
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.service.resume.ResumeFileMapper.";
	
	public int addResumeFile(ResumeFile resumeFile) {
		int row = sqlSession.insert(NS+"addResumeFile",resumeFile);
		return row;
	}
}
