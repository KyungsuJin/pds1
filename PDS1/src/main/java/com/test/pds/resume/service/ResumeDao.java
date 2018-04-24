package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeDao {
	private static final Logger logger = LoggerFactory.getLogger(ResumeDao.class);
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.service.resume.ResumeMapper.";
	
	public int addResume(Resume resume) {
		int low = sqlSession.insert(NS+"addResume",resume);
		return low;
	}
}