package com.test.mall1.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall1.IndexController;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public int addMember(Member member) {
		logger.info("MemberService 의 addMember 메서드 실행");
		int row = memberDao.insertMember(member);
		return row;
	}
	
	
}
