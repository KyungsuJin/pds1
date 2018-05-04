package com.test.pds.member.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.article.service.Article;
import com.test.pds.article.service.ArticleDao;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);
	final String NS = "com.test.pds.member.service.MemberMapper.";
	@Autowired private SqlSessionTemplate sqlSession;
	
	public Member memberIdCheck(Member member) {
		return sqlSession.selectOne(NS + "selectMemberById", member);
	}
	
	public void addMember(Member member) {
		sqlSession.insert(NS + "insertMember", member);
	}
	
	public boolean loginMember(Member member) {
		logger.debug("MemberDao.loginMember ");
		if(sqlSession.selectOne(NS + "selectMemberOne", member) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public int memberTotalCount() {
		return sqlSession.selectOne(NS+"selectMemberCount");
	}
	
	public List<Member> getMemberList(Map map){
		List<Member> list = sqlSession.selectList(NS+"selectMemberList", map);
		return list;
	}
	
	public void removeMember(Member member) {
		sqlSession.delete(NS+"deleteMember", member);
	}
	
	public Member getMemberInfo(Member member) {
		return sqlSession.selectOne(NS+"selectMemberById", member);
	}
	
	public void modifyMember(Member member) {
		sqlSession.update(NS+"updateMember", member);
	}
}
