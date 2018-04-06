package com.test.mall1.member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS = "com.test.mall1.member.service.MemberMapper.";
	
	public int insertMember(Member member) {
		logger.info("MemberDao 클래스의 insertMember메서드 실행");
		int row = sqlSession.insert(NS+"insertMember",member);
		return row;
	}
	
	public List<Member> selectMemberList(Map<String, Integer> map) {
		logger.info("MemberDao 클래스의 selectMemberList메서드 실행");
		List<Member> list = sqlSession.selectList(NS+"selectMemberList", map);
		return list;
	}
	
	public Member selectMemberById(Member member) {
		logger.info("MemberDao 클래스의 selectMemberById메서드 실행");
		return sqlSession.selectOne(NS+"selectMemberById", member);
	}
	
	public int totalCountMember() {
		logger.info("MemberDao 클래스의 selectMemberById메서드 실행");
		return sqlSession.selectOne(NS+"totalCountMember");
	}
}
