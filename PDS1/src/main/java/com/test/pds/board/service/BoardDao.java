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
	public List<Board> getDetailList(int boardId){
		logger.debug("BoardDao.getDetailList");
		return sqlSession.selectList(NS+"getDetailList",boardId);
	}
	public int totalCountList() {
		logger.debug("BoardDao.totalCountList");
		return sqlSession.selectOne(NS+"totalCountList");
	}
	public void modifyBoard(Board board) {
		logger.debug("BoardDao.modifyBoard");
		sqlSession.update(NS+"modifyBoard",board);
	}
}
