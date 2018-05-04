package com.test.pds.resume.service;

public class Resume {
	private int resumeId;
	private String resumeTitle;
	private String resumeContent;
	private String resumeDate;
	private int resumeCount;
	
	public String getResumeDate() {
		return resumeDate;
	}
	public void setResumeDate(String resumeDate) {
		this.resumeDate = resumeDate;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	public String getResumeContent() {
		return resumeContent;
	}
	public void setResumeContent(String resumeContent) {
		this.resumeContent = resumeContent;
	}
	public int getResumeCount() {
		return resumeCount;
	}
	public void setResumeCount(int resumeCount) {
		this.resumeCount = resumeCount;
	}
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", resumeTitle=" + resumeTitle + ", resumeContent=" + resumeContent
				+ ", resumeDate=" + resumeDate + ", resumeCount=" + resumeCount + "]";
	}
}
