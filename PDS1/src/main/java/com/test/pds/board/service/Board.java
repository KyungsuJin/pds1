package com.test.pds.board.service;

import java.util.List;

/*
 * board
 */
public class Board {
	private int boardId;
	private String boardTitle; //board_title
	private String boardContent; //board_content
	private List<BoardFile> boardFile;
	
	public List<BoardFile> getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(List<BoardFile> boardFile) {
		this.boardFile = boardFile;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	

	public String toString() {
		return "Board [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardFile=" + boardFile + "]";
	}
	
	

}
