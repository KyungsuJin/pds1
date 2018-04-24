package com.test.pds.notice.service;

import java.util.List;

public class Notice {
	private int noticeId; //notice_id
	private String noticeTitle; //notice_title
	private String noticeContent; //notice_content
	private NoticeFile noticeFile;
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public NoticeFile getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(NoticeFile noticeFile) {
		this.noticeFile = noticeFile;
	}
	
}