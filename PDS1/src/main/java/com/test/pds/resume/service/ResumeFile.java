package com.test.pds.resume.service;

public class ResumeFile {
	private int resumeFileId;
	private String resumeFileName;
	private String resumeFileType;
	private int resumeFileSize;
	private String resumeFileExt;
	private int resumeId;
	public int getResumeFileId() {
		return resumeFileId;
	}
	public void setResumeFileId(int resumeFileId) {
		this.resumeFileId = resumeFileId;
	}
	public String getResumeFileName() {
		return resumeFileName;
	}
	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}
	public String getResumeFileType() {
		return resumeFileType;
	}
	public void setResumeFileType(String resumeFileType) {
		this.resumeFileType = resumeFileType;
	}
	public int getResumeFileSize() {
		return resumeFileSize;
	}
	public void setResumeFileSize(int resumeFileSize) {
		this.resumeFileSize = resumeFileSize;
	}
	public String getResumeFileExt() {
		return resumeFileExt;
	}
	public void setResumeFileExt(String resumeFileExt) {
		this.resumeFileExt = resumeFileExt;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	@Override
	public String toString() {
		return "ResumeFile [resumeFileId=" + resumeFileId + ", resumeFileName=" + resumeFileName + ", resumeFileType="
				+ resumeFileType + ", resumeFileSize=" + resumeFileSize + ", resumeFileExt=" + resumeFileExt
				+ ", resumeId=" + resumeId + "]";
	}
	
}
