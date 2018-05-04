package com.test.pds.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	private static Logger logger = LoggerFactory.getLogger(BoardFileDao.class);
	final String NS = "com.test.pds.board.service.BoardMapper.";
	//파일추가
	public void addBoardFile(Map<String,Object> map) {
		logger.debug("BoardFileDao.addBoardFile");
		sqlSession.insert(NS+"addBoardFile",map);
	}
	//DB에 파일 정보 삭제
	public void modifyBoardFile(int boardFileId) {
		logger.debug("BoardFileDao.modifyBoardFile //delete");

		sqlSession.delete(NS+"modifyBoardFile",boardFileId);
	}
	//서버에 파일을 삭제하기위해 DB파일 정보를 가져온다 
	public BoardFile deleteServerFileList(int boardFileId){
		logger.debug("BoardFileDao.deleteServerFileList");
		return sqlSession.selectOne(NS+"deleteServerFileList",boardFileId);
		
	}
	public List<BoardFile> deleteBoardList(int boardId) {
		logger.debug("BoardFileDao.deleteBoard");
		return sqlSession.selectList(NS+"deleteBoardList",boardId);
	}
	public void deleteBoard(int boardId) {
		logger.debug("BoardFileDao.deleteBoard");
		sqlSession.delete(NS+"deleteBoardFile",boardId);
	}


}
