package com.test.pds.board.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		List<MultipartFile> multipartFileList = boardRequest.getMultipartFile();
		logger.debug("multipartFile : "+multipartFileList);
		logger.debug("path : "+path);
		
		Board board = new Board();
		ArrayList<BoardFile> boardFileList = new ArrayList<BoardFile>();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		int boardId=boardDao.addBoard(board);
		for(MultipartFile multipartFile: multipartFileList) {
			BoardFile boardFile = new BoardFile();
			boardFile.setBoardId(boardId);
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
			logger.debug(board.toString());
			boardFileList.add(boardFile);
			
			File file = new File("d:/upload/"+fileName+"."+fileExt);
			logger.debug("file : "+file);
		
			try {
				multipartFile.transferTo(file);
			}catch(IOException e) {
				e.printStackTrace();
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}
		}
		logger.debug(boardFileList.toString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("boardFileList", boardFileList);
		boardFileDao.addBoardFile(map);
		
	}
	public void getBoardList() {
		boardDao.getBoardList();
	}

}
