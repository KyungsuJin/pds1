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

import com.test.pds.SystemPath;

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
				File file = new File(SystemPath.DOWNLOAD_PATH+fileName+"."+fileExt);
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
	//페이징 메서드
	public Map<String,Object> getBoardList(int currentPage,int pagePerRow) {
		logger.debug("boardService.getBoardList");
		Map<String,Integer> map = new HashMap<String,Integer>();
		int beginRow = (currentPage-1)*10+1;//LIMIT 의 앞부분을 구한다
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list=boardDao.getBoardList(map);
		int totalCountList =boardDao.totalCountList();//게시물의 총개수
		logger.debug("boardDao.totalCountList");
		
		int lastPage=totalCountList/pagePerRow;//마지막 페이지를 구한다
		if(totalCountList%pagePerRow>0) {//한페이지에 10개씩 보여주고 총게시물이 101개라면 페이지는 11페이지가 되어야하는데 10페이지되므로 사용해준다.
			lastPage++;
		}
		int startPage=((currentPage-1)/10)*10+1;//숫자 페이징작업 밑부분 보여질 시작 범위
		int endPage = startPage*10-1;//숫자 페이징 작업 밑부분 보여줄 마지막 범위
		if(endPage>lastPage) {
			endPage=lastPage;
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("startPage", startPage);
		returnMap.put("endPage", endPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}
	//게시물의 내용을 보여주는 메서드
	public List<Board> getDetailList(int boardId){
		logger.debug("boardService.getDetailList");
		return boardDao.getDetailList(boardId);
	}
	//수정 메서드
	public void modifyBoard(BoardRequest boardRequest) {
		logger.debug("BoardService.modifyBoard");
		Board board= new Board();
		List<MultipartFile> multipartFileList =boardRequest.getMultipartFile();//파일 리스트
		ArrayList<BoardFile> boardFileList = new ArrayList<BoardFile>();//BoardFile DTO 리스트
		logger.debug("board"+boardRequest.getBoardId());
		board.setBoardId(boardRequest.getBoardId());//contorller 에서받아온 BoardRequest 의 boardId를 board에 저장
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		boardDao.modifyBoard(board);//board 수정부분
		if(boardRequest.getBoardDeleteList()!=null) {//삭제를 요청한 파일 아이디의 번호가 있으면 해당 IF 문 실행
			for(int boardFileId : boardRequest.getBoardDeleteList()) {//파일 ID 는 리스트 이므로 값을 for 문을 이용해 꺼내준다.
				logger.debug("for : modifyBoardFile");
				BoardFile boardFile=boardFileDao.deleteServerFileList(boardFileId);//DB 에 저장된 파일의 정보를 가져온다.
				logger.debug(boardFile.getBoardFileName());
				logger.debug(boardFile.getBoardFileExt());
				File file = new File(SystemPath.DOWNLOAD_PATH+boardFile.getBoardFileName()+"."+boardFile.getBoardFileExt());//서버 파일을 삭제
				file.delete();
				boardFileDao.modifyBoardFile(boardFileId);//파일 ID 를 통해 DB 파일 정보를 삭제한다.
			}
		}
		if(multipartFileList!=null) {//파일리스트가 있다면 실행
			for(MultipartFile multipartFile: multipartFileList) {
				BoardFile boardFile = new BoardFile();
				UUID uuid =  UUID.randomUUID();
				String fileName =uuid.toString().replaceAll("-", "");
				boardFile.setBoardFileName(fileName);
				String fileExt = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
				boardFile.setBoardFileExt(fileExt);
				boardFile.setBoardFileType(multipartFile.getContentType());
				boardFile.setBoardFileSize(multipartFile.getSize());
				boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
				boardFile.setBoardId(boardRequest.getBoardId());
				logger.debug(boardFile.toString());
				boardFileList.add(boardFile);
				File file = new File(SystemPath.DOWNLOAD_PATH+fileName+"."+fileExt);
				logger.debug("file : "+file);
				try {
					multipartFile.transferTo(file);
				}catch(IOException e) {
					e.printStackTrace();
				}catch(IllegalStateException e) {
					e.printStackTrace();
				}
			}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("boardFileList", boardFileList);
			boardFileDao.addBoardFile(map);
			
			}
		
		}
	public void deleteBoard(int boardId) {
		logger.debug("BoardService.deleteBoard");
		List<BoardFile> list =boardFileDao.deleteBoardList(boardId);
		if(list!=null) {
			boardFileDao.deleteBoard(boardId);
			for(BoardFile boardFile : list){
				File file = new File(SystemPath.DOWNLOAD_PATH+boardFile.getBoardFileName()+"."+boardFile.getBoardFileExt());//서버 파일을 삭제
				file.delete();
			}
		}
		boardDao.deleteBoard(boardId);
	}

}
