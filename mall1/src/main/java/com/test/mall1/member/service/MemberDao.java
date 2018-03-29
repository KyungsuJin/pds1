package com.test.mall1.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.test.mall1.IndexController;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	public void insertMember(Member member) {
		logger.info("MemberDao 클래스의 insertMember메서드 실행");
	}
}
