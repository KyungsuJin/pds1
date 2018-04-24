package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	private static final Logger logger= LoggerFactory.getLogger(BoardService.class);
	
	public void addBoard(BoardRequest boardRequest,String path) {
		logger.info("BoardService addBoard");
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		logger.info("multipartFile : "+multipartFile);
		logger.info("path : "+path);
		
		Board board = new Board();
		BoardFile boardFile = new BoardFile();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString().replaceAll("-", "");
		logger.info("boardFile.setBoardFileName : "+fileName);
		boardFile.setBoardFileName(fileName);
		
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		logger.info("dotIndex : "+dotIndex);
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		logger.info("boardFile.setBoardFileExt : "+fileExt);
		boardFile.setBoardFileExt(fileExt);
		
		String fileType= multipartFile.getContentType();
		logger.info("boardFile.setBoardFileType : "+fileType);
		boardFile.setBoardFileType(fileType);
		
		long fileSize = multipartFile.getSize();
		logger.info("boardFile.setBoardFileSize : "+fileSize);
		boardFile.setBoardFileSize(fileSize);
		
		logger.info(boardFile.toString());
		board.setBoardFile(boardFile);
		logger.info(board.toString());
		File file = new File("d:/upload/"+fileName+"."+fileExt);
		logger.info("file : "+file);
		
		try {
			multipartFile.transferTo(file);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		
		boardDao.addBoard(board);
	}

}
