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
	//파일추가 메서드 
	public void addBoard(BoardRequest boardRequest,String path) {
		logger.debug("BoardService.addBoard");
		//여러개의 파일을 받아 list 에 담는다.
		List<MultipartFile> multipartFileList = boardRequest.getMultipartFile();
		logger.debug("multipartFile : "+multipartFileList);
		logger.debug("path : "+path);
		
		Board board = new Board();
		//boardFile 리스트를 만들었다.
		ArrayList<BoardFile> boardFileList = new ArrayList<BoardFile>();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		//board와 boardFile 을 조인하기위한 id 값을 리턴받아 저장한다.
		int boardId=boardDao.addBoard(board);
		//for 문을 활용해 multipartFileList 에 저장되어있는 리스트들을 한개씩불러와 for문 안의 내용을 실행한다.
			for(MultipartFile multipartFile: multipartFileList) {
				//boardFile 객체생성
				BoardFile boardFile = new BoardFile();
				boardFile.setBoardId(boardId);
				//UUID의 랜덤메서드를 사용해 uuid 변수에 랜덤한 난수를 생성해 저장한다.
				UUID uuid = UUID.randomUUID();
				//uuid에는 - 가 다수 포함되어있으므로 불러와 toString 메서드와 replaceAll 메서드로 -를 없애준다.
				String fileName = uuid.toString().replaceAll("-", "");
				logger.debug("boardFile.setBoardFileName : "+fileName);
				//-를 없앤 uuid 를 저장한다.
				boardFile.setBoardFileName(fileName);
				//파일의 원래이름을 가져온다.
				String name =multipartFile.getOriginalFilename();
				logger.debug("debug : "+name);
				boardFile.setOriginalFileName(name);
				//파일의 마지막 점의 위치를 가져온다.
				int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
				logger.debug("dotIndex : "+dotIndex);
				//파일의 마지막점위치의 다음부터 subString 메서드를 사용해 잘라온다. 확장자명을 구해오기위함
				String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
				logger.debug("boardFile.setBoardFileExt : "+fileExt);
				boardFile.setBoardFileExt(fileExt);
				//파일의 타입을 가져온다
				String fileType= multipartFile.getContentType();
				logger.debug("boardFile.setBoardFileType : "+fileType);
				boardFile.setBoardFileType(fileType);
				//파일의 사이즈를 가져온다.
				long fileSize = multipartFile.getSize();
				logger.debug("boardFile.setBoardFileSize : "+fileSize);
				boardFile.setBoardFileSize(fileSize);
				
				logger.debug(boardFile.toString());
				logger.debug(board.toString());
				//리스트에 boardFile을 저장한다.
				boardFileList.add(boardFile);
				//파일을 옮길 경로
				File file = new File("d:/upload/"+fileName+"."+fileExt);
				logger.debug("file : "+file);
			
				try {
					//파일을 해당경로로 옮긴다.
					multipartFile.transferTo(file);
				}catch(IOException e) {
					e.printStackTrace();
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}
			}
			logger.debug(boardFileList.toString());
			//맵을 만들어 list를 boardFileDao.addBoardFile 로 보내 처리한다.
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("boardFileList", boardFileList);
			boardFileDao.addBoardFile(map);
		}
	public List<Board> getBoardList() {
		logger.debug("boardService.getBoardList");
		return boardDao.getBoardList();
	}
	public List<Board> getDetailList(int boardId){
		logger.debug("boardService.getDetailList");
		return boardDao.getDetailList(boardId);
		 
	}

}
