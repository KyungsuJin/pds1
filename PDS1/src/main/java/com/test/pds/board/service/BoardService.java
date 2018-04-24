package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class BoardService {
	@Autowired
	BoardDao boardDao;
	@Autowired
	BoardFileDao boardFileDao;
	
	
	private static final Logger logger= LoggerFactory.getLogger(BoardService.class);
	
	public void addBoard(BoardRequest boardRequest,String path) {
		logger.debug("BoardService.addBoard");
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		logger.debug("multipartFile : "+multipartFile);
		logger.debug("path : "+path);
		
		Board board = new Board();
		BoardFile boardFile = new BoardFile();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString().replaceAll("-", "");
		logger.debug("boardFile.setBoardFileName : "+fileName);
		boardFile.setBoardFileName(fileName);
		String name =multipartFile.getOriginalFilename();
		logger.debug("debug : "+name);
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		logger.debug("dotIndex : "+dotIndex);
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		logger.debug("boardFile.setBoardFileExt : "+fileExt);
		boardFile.setBoardFileExt(fileExt);
		
		String fileType= multipartFile.getContentType();
		logger.debug("boardFile.setBoardFileType : "+fileType);
		boardFile.setBoardFileType(fileType);
		
		long fileSize = multipartFile.getSize();
		logger.debug("boardFile.setBoardFileSize : "+fileSize);
		boardFile.setBoardFileSize(fileSize);
		
		logger.debug(boardFile.toString());
		board.setBoardFile(boardFile);
		logger.debug(board.toString());
		File file = new File("d:/upload/"+fileName+"."+fileExt);
		logger.debug("file : "+file);
		
		try {
			multipartFile.transferTo(file);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		
		boardDao.addBoard(board);
		logger.debug(boardFile.toString());
		boardFileDao.addBoardFile(boardFile);
	}

}
