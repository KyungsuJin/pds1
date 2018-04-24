package com.test.pds.resume.service;

import java.util.List;

public class Resume {
	private int resumeId;
	private String resumeTitle;
	private String resumeContent;
	private ResumeFile resumeFile;
	
	public ResumeFile getResumeFile() {
		return resumeFile;
	}
	public void setResumeFile(ResumeFile resumeFile) {
		this.resumeFile = resumeFile;
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
	@Override
	public String toString() {
		return "Resume [resumeId=" + resumeId + ", resumeTitle=" + resumeTitle + ", resumeContent=" + resumeContent
				+ "]";
	}

}
