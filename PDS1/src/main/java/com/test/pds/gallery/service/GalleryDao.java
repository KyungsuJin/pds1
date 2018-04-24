package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDao {
	private static final Logger logger = LoggerFactory.getLogger(GalleryDao.class);
	
	@Autowired
	SqlSessionTemplate sqlSession;
	final String NS = "com.test.pds.gallery.service.GalleryMapper.";
	
	//Gallery의 목록을 보여주기위한 메서드 리스트타입으로 리턴하여 목록을 보여준다.
	public List<Gallery> getGalleryList() {
		logger.debug("GalleryDao_getGalleryList");
		List<Gallery> list = sqlSession.selectList(NS+"selectGalleryList");
		return list;
	}
	//Gallery를 추가하는 메서드 매개변수로 화면에서 입력받은 데이터를 받는 Gallery타입을 받는다.
	public int addGallery(Gallery gallery) {
		logger.debug("GalleryDao_addGallery");
		return sqlSession.insert(NS+"insertGallery", gallery);
	}
}
