package com.test.pds.member.service;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberPwCheck;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPwCheck() {
		return memberPwCheck;
	}
	public void setMemberPwCheck(String memberPwCheck) {
		this.memberPwCheck = memberPwCheck;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberPwCheck=" + memberPwCheck + "]";
	}
	
}
