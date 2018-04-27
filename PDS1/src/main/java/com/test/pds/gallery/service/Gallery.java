package com.test.pds.gallery.service;

import java.util.List;

public class Gallery {
	private int galleryId;
	private String galleryTitle;
	private String galleryContent;
	private GalleryFile galleryFile;
	private List<Gallery> galleryFileList;
	
	
	public List<Gallery> getGalleryFileList() {
		return galleryFileList;
	}
	public void setGalleryFileList(List<Gallery> galleryFileList) {
		this.galleryFileList = galleryFileList;
	}
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getGalleryTitle() {
		return galleryTitle;
	}
	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}
	public String getGalleryContent() {
		return galleryContent;
	}
	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}
	public GalleryFile getGalleryFile() {
		return galleryFile;
	}
	public void setGalleryFile(GalleryFile galleryFile) {
		this.galleryFile = galleryFile;
	}
	@Override
	public String toString() {
		return "Gallery [galleryId=" + galleryId + ", galleryTitle=" + galleryTitle + ", galleryContent="
				+ galleryContent + ", galleryFile=" + galleryFile + "]";
	}

}
	
