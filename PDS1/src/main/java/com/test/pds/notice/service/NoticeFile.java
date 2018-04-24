package com.test.pds.notice.service;

public class NoticeFile {
	
	private int noticeFileId;
	private String noticeFileName;
	private int noticeId;
	private String noticeFileExt;
	private String noticeFileType;
	private long noticeFileSize;
	public int getNoticeFileId() {
		return noticeFileId;
	}
	public void setNoticeFileId(int noticeFileId) {
		this.noticeFileId = noticeFileId;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeFileExt() {
		return noticeFileExt;
	}
	public void setNoticeFileExt(String noticeFileExt) {
		this.noticeFileExt = noticeFileExt;
	}
	public String getNoticeFileType() {
		return noticeFileType;
	}
	public void setNoticeFileType(String noticeFileType) {
		this.noticeFileType = noticeFileType;
	}
	public long getNoticeFileSize() {
		return noticeFileSize;
	}
	public void setNoticeFileSize(long noticeFileSize) {
		this.noticeFileSize = noticeFileSize;
	}
	@Override
	public String toString() {
		return "NoticeFile [noticeFileId=" + noticeFileId + ", noticeFileName=" + noticeFileName + ", noticeId="
				+ noticeId + ", noticeFileExt=" + noticeFileExt + ", noticeFileType=" + noticeFileType
				+ ", noticeFileSize=" + noticeFileSize + "]";
	}

}