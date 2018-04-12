package com.test.mall1.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	final String NS = "com.test.mall1.board.service.BoardMapper.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int deleteBoard(int boardNo) {
	/*
	 * 등록된 게시글을 삭제하는 메서드!
	 * 매개변수로 해당 게시글의 번호를 받는다.
	 */
		logger.info("BoardDao 클래스의 deleteBoard");
		return sqlSession.delete(NS+"deleteBoard", boardNo);
	}
	public int updateBoard(Board board) {
	/*
	 * 게시판 수정화면에서 수정된 데이터가 넘어와 처리하는 메서드
	 * 매개변수로 수정된 데이터를 담은 board를 받고 excuteUpdate후 성공했다면 1을 리턴한다.
	 */
		logger.info("BoardDao 클래스의 updateBoard");
		return sqlSession.update(NS+"updateBoard", board);
	}
	public Board boardDetailView(int boardNo) {
	/*
	 * 하나의 게시물을 선택하여 상세보기를 할수 있는 메서드
	 * 매개변수로 해당게시물의 번호를 받아 SELECT한후 Board 객체담아 화면에 뿌려준다.
	 */
		logger.info("BoardDao 클래스의 boardDetailView");
		logger.info(boardNo+"<---boardNo");
		return sqlSession.selectOne(NS+"selectBoardView", boardNo);
	}
	public int totalCountBoard() {
	/*
	 * 게시물의 총 수를 구하는 메서드, 페이징작업할때 마지막페이지를 표현하기 위함
	 * SELECT COUNT를 사용하기 때문에 총수를 구한후 int로 return 해준다.
	 */
		logger.info("BoardDao 클래스의 totalCountBoard");
		return sqlSession.selectOne(NS+"totalCountBoard");
	}
	public List<Board> selectBoardList(Map<String, Integer> map) {
		/*
		 * 게시물을 리스트 형태로 보여주는 메서드
		 * return 타입은 화면에 뿌려줄 List 타입이고, 어디서 부터 몇개까지 보여줄것인지 정하기위해 beginRow와 pagePerRow를
		 * 담은 map을 매개변수로 받는다.
		 */
		logger.info("BoardDao 클래스의 selectBoardList");
		List<Board> list = sqlSession.selectList(NS+"selectBoardList", map);
		logger.info("BoardDao 클래스의 selectBoardList2");
		return list;
	}
	public int insertBoard(Board board) {
		/*
		 * 게시글을 쓰기위한 메서드
		 * 입력받은 내용이 담겨있는 Board타입의 board 변수를 받는다.
		 * excuteUpdate후 성공했다면 1을 리턴한다.
		 */
		logger.info("BoardDao 클래스의 insertBoard");
		return sqlSession.insert(NS+"insertBoard", board);
	}
}
