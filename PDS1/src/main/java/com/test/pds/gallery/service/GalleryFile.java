package com.test.pds.gallery.service;

public class GalleryFile {
	private int galleryFileId;
	private int galleryId;
	private String galleryFileName;
	private String galleryFileExt;
	private String galleryFileType;
	private long galleryFileSize;
	
	public int getGalleryFileId() {
		return galleryFileId;
	}
	public void setGalleryFileId(int galleryFileId) {
		this.galleryFileId = galleryFileId;
	}
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getGalleryFileName() {
		return galleryFileName;
	}
	public void setGalleryFileName(String galleryFileName) {
		this.galleryFileName = galleryFileName;
	}
	public String getGalleryFileExt() {
		return galleryFileExt;
	}
	public void setGalleryFileExt(String galleryFileExt) {
		this.galleryFileExt = galleryFileExt;
	}
	public String getGalleryFileType() {
		return galleryFileType;
	}
	public void setGalleryFileType(String galleryFileType) {
		this.galleryFileType = galleryFileType;
	}
	public long getGalleryFileSize() {
		return galleryFileSize;
	}
	public void setGalleryFileSize(long galleryFileSize) {
		this.galleryFileSize = galleryFileSize;
	}
	
	@Override
	public String toString() {
		return "GalleryFile [galleryFileId=" + galleryFileId + ", galleryId=" + galleryId + ", galleryFileName="
				+ galleryFileName + ", galleryFileExt=" + galleryFileExt + ", galleryFileType=" + galleryFileType
				+ ", galleryFileSize=" + galleryFileSize + "]";
	}

	
}
