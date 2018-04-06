package com.test.mall1.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Map<String, Object> selectMemberList(int currentPage, int pagePerRow) {
		logger.info("MemberService 의 selectMemberList 메서드 실행");
		int beginRow = (currentPage-1)*pagePerRow;
		//1. 총 row 수 전부다 받아옴
		int totalRow = memberDao.totalCountMember();
		int lastPage = totalRow/pagePerRow;
		if(totalRow%pagePerRow != 0) {
			lastPage++;
		}
		//해당 페이지에 보여줘야할 멤버리스트를 가져옴
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		//그 가져온 정보를 리스트에넣는다.
		List<Member> list = memberDao.selectMemberList(map);
		//근데 리턴해줄때 하나의 변수에 넣어서 보내야 하기때문에, 새로운 맵을 만드는데, Object를 써서 형이 달라도 넣을수있도록 한다.
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("beforePage", ((currentPage-1)/10)*10);
		returnMap.put("nextPage", ((currentPage-1)/10)*10+11);
		returnMap.put("list", list);
		
		return returnMap;
	}
	
	public Member getMemberById(Member member) {
		logger.info("MemberService 의 selectMemberById 메서드 실행");
		return memberDao.selectMemberById(member);
	}
	
}
