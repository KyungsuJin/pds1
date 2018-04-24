package com.test.pds.board.service;
/*
 * board_file
 */
public class BoardFile {
	private String boardFileName; //board_file_name
	private String boardFileExt; //board_file_ext
	private String boardFileType; //board_file_type
	private long boardFileSize; //board_file_size
	private int boardId; ////board_id
	
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFileExt() {
		return boardFileExt;
	}
	public void setBoardFileExt(String boardFileExt) {
		this.boardFileExt = boardFileExt;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}
	public long getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(long boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	@Override
	public String toString() {
		return "BoardFile [boardFileName=" + boardFileName + ", boardFileExt=" + boardFileExt + ", boardFileType="
				+ boardFileType + ", boardFileSize=" + boardFileSize + ", boardId=" + boardId + "]";
	}
	
	

}
