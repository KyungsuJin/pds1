package com.test.mall1.board_comment.service;

public class Board_comment {
	 
	private int comment_no;
	private int board_no;
	private String comment_content;
	private String member_id;
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	@Override
	public String toString() {
		return "Board_comment [comment_no=" + comment_no + ", board_no=" + board_no + ", comment_content="
				+ comment_content + ", member_id=" + member_id + "]";
	}
}
