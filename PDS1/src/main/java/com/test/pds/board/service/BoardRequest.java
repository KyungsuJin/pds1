package com.test.pds.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardRequest {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private List<Integer> boardDeleteList;
	private List<MultipartFile> multipartFile;
	
	
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public List<Integer> getBoardDeleteList() {
		return boardDeleteList;
	}
	public void setBoardDeleteList(List<Integer> boardDeleteList) {
		this.boardDeleteList = boardDeleteList;
	}
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
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
	
	@Override
	public String toString() {
		return "BoardRequest [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", multipartFile="
				+ multipartFile + "]";
	}
	
	
	
}
