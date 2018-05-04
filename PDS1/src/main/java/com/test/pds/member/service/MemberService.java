package com.test.pds.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.pds.article.service.Article;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public Member memberIdCheck(Member member) {
		return memberDao.memberIdCheck(member);
	}
	
	public void addMember(Member member) {
		if(member == null) {
			
		} else if((member.getMemberId().length() < 4)
				|| !member.getMemberPw().equals(member.getMemberPwCheck())
				|| member.getMemberPw().length() < 4) {
			
		}else {
			memberDao.addMember(member);
		}
	}
	
	public boolean loginMember(Member member) {
		return memberDao.loginMember(member);
	}
	
	public Map<String, Object> getMemberList(int currentPage, int pagePerRow){
		int totalRow = memberDao.memberTotalCount();
		int firstPage = 1;
		int lastPage = totalRow/pagePerRow;
		if(totalRow%pagePerRow != 0) {
			lastPage++;
		}
		int beforePage = ((currentPage-1)/10)*10;
		int afterPage = ((currentPage-1)/10)*10 +11;
		
		Map pageMap = new HashMap<String, Integer>();
		pageMap.put("beginRow", (currentPage-1)*10);
		pageMap.put("pagePerRow", pagePerRow);
		
		Map map = new HashMap<String, Object>();
		List<Member> list = memberDao.getMemberList(pageMap);
		map.put("list", list);
		map.put("firstPage", firstPage);
		map.put("lastPage", lastPage);
		map.put("beforePage", beforePage);
		map.put("afterPage", afterPage);
		return map;
	}
	
	public void removeMember(Member member) {
		memberDao.removeMember(member);
	}
	
	public Member getMemberInfo(Member member) {
		return memberDao.getMemberInfo(member);
	}
	
	public void modifyMember(Member member) {
		memberDao.modifyMember(member);
	}
}
