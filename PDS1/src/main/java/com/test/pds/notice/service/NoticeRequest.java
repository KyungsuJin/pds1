package com.test.pds.notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NoticeRequest {
	private String noticetitle;
	private String noticeContent;
	private List<MultipartFile> multipartFile;
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "NoticeRequest [noticetitle=" + noticetitle + ", noticeContent=" + noticeContent + ", multipartFile="
				+ multipartFile + "]";
	}
}
