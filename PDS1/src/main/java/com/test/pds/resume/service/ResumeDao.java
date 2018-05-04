package com.test.pds.resume.service;

import java.util.List;

import java.util.Map;

 

import org.mybatis.spring.SqlSessionTemplate;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class ResumeDao {
	private static final Logger logger = LoggerFactory.getLogger(ResumeDao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.resume.service.ResumeMapper.";
	
	public int updateResume(Resume resume) {
		logger.debug("ResumeDao - updateResume 조회수 실행");
		return sqlSession.update(NS+"updateResumeOne",resume);
	}

	public Resume selectOneResume(int resumeId) {
		logger.debug("ResumeDao - selectOneresume resume 1개 선택 실행");
		return sqlSession.selectOne(NS+"selectResumeOne",resumeId);
	}
	
	public int deleteResume(int resumeId) {
		logger.debug("ResumeDao - deleteResume 실행");
		return sqlSession.delete(NS+"deleteResume",resumeId);
    }
	
	public int resumeCount() {
		logger.debug("ResumeDao - resumeCount 실행");
		return sqlSession.selectOne(NS+"resumeCount");
	}
	
	public List<Resume> selectResume(Map<String,Integer> map) {
		logger.debug("ResumeDao - selectResume 실행");
		 List<Resume> list =sqlSession.selectList(NS+"selectResume",map);
		return list;
	}
	
	public int addResume(Resume resume) {
		logger.debug("ResumeDao - addResume 실행");
		sqlSession.insert(NS+"addResume",resume);
		int id = resume.getResumeId();
		logger.debug("id :" + id);
		return id;
	}
}