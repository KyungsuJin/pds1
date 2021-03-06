package com.test.pds.gallery.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryFileDao {
	private static final Logger logger = LoggerFactory.getLogger(GalleryDao.class);
	
	@Autowired
	SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.gallery.service.GalleryFileMapper.";
	
	public int selectGalleryFileTotal(int galleryId) {
		logger.debug("GalleryFileDao_selectGalleryFileTotal");
		return sqlSession.selectOne(NS+"selectGalleryFileTotal", galleryId);
	}
	public int removeGallery(int galleryId) {
		logger.debug("GalleryFileDao_removeGallery");
		return sqlSession.delete(NS+"removeGalleryFile",galleryId);
		
	}
	public int addGalleryFile(GalleryFile galleryFile) {
		logger.debug("GalleryFileDao_addGalleryFile");
		return sqlSession.insert(NS+"addGalleryFile", galleryFile);
	}	
}
