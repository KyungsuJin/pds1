package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class ResumeFileDao {
	private static final Logger logger = LoggerFactory.getLogger(ResumeFileDao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.resume.service.ResumeFileMapper.";
	
	public int deleteResumeFile(int resumeId) {
		logger.debug("ResumeFileDao - deleteResumeFile 실행");
		return sqlSession.delete(NS+"deleteResumeFile",resumeId);
    }
	
	public ResumeFile selectResumeFile(int resumeId) {
		logger.debug("ResumeFileDao - selectResumeFile 실행");
		return sqlSession.selectOne(NS+"selectResumeFile", resumeId);
	}
	
	public void addResumeFile(ResumeFile resumeFile) {
		logger.debug("ResumeFileDao - addResumeFile 실행");
		sqlSession.insert(NS+"addResumeFile",resumeFile);
	}
}