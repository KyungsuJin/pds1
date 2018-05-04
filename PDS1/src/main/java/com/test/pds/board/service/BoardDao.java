package com.test.pds.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	private static final Logger logger= LoggerFactory.getLogger(BoardDao.class);
	final String NS ="com.test.pds.board.service.BoardMapper.";
	//파일 추가
	public int addBoard(Board board) {
		logger.debug("BoardDao.addBoard");
		sqlSession.insert(NS+"insertBoard",board);
		int boardId =board.getBoardId();
		logger.debug("boardId : "+board.getBoardId());
		return boardId;
	}
	//파일 리스트
	public List<Board> getBoardList(Map<String,Integer> map) {
		logger.debug("BoardDao.getBoardList");
		return sqlSession.selectList(NS+"getBoardList",map);
	}
	//파일 클릭시 하나의 리스트
	public List<Board> getDetailList(int boardId){
		logger.debug("BoardDao.getDetailList");
		return sqlSession.selectList(NS+"getDetailList",boardId);
	}
	//총 개시물의 수
	public int totalCountList() {
		logger.debug("BoardDao.totalCountList");
		return sqlSession.selectOne(NS+"totalCountList");
	}
	//DB의 board 정보 수정
	public void modifyBoard(Board board) {
		logger.debug("BoardDao.modifyBoard");
		sqlSession.update(NS+"modifyBoard",board);
	}
	public void deleteBoard(int boardId) {
		logger.debug("BoardDao.deleteBoard");
		sqlSession.delete(NS+"deleteBoard1",boardId);
		
	}
}
