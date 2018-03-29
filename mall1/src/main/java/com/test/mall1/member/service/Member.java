package com.test.mall1.member.service;

public class Member {
	private int memberNo;
	private int memberId;
	private int memberPw;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(int memberPw) {
		this.memberPw = memberPw;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + "]";
	}
	
}
