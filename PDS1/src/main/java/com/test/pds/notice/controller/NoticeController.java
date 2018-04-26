/* 										//Controller 부터 주석 작성시작 Controller > Dao > Mapper 순
public class NoticeController {			//controller 어노테이션 사용해서 컨트롤러 기능 사용하게 해준다. //은 안써도 되는데 구분되라고 써줌.
	package com.test.pds.board.controller;

	import java.util.List;

	import javax.servlet.http.HttpSession;

	import org.slf4j.Logger;	//import 는 사용할 패키지를 선언하는데 사용한다고 한다 검색하니 나왔다.
	 							//원래 원장선생님께 초반에 배웠을 때에는 줄여서 쓰기 위해서 사용한다고만 알고 있었다. 사용하다보니 점차 다른 곳에 있는 메서드 쓸떄 쓰다보니
	 							//다른 곳으로 연결해 주는줄 착각하고있었다.
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.multipart.MultipartFile;

	import com.test.pds.board.service.Board;
	import com.test.pds.board.service.BoardRequest;
	import com.test.pds.board.service.BoardService;

	@Controller 		// Controller 이노테이션 컨트롤러 로써 기능하게 해준다고만 알고있었다.
						//검색해보니 명시적으로 해주는것이었고 기능적으로 연관이 있다고는 생각하는데 그에 대해서 자세한 설명이 필요할듯하다.
	public class boardController {
		@Autowired	미리 생성된 빈을 자동으로 주입해주며, 한개만 존재하는 것만 사용 가능하다고한다.
					내용은 얼추 알고 있었는데 단 한개만 존재하는것에만 사용 가능하다는것은 몰랐다.
		BoardService boardService; 
			//↑위의 코드는  사용할 수 있도록선언 해준것이다. 이제 이 이하로는 boardService 에 도트연산자 사용해서 하위에 메서드 들어가서 값 받아오거나 할때 쓸려고 한것으로안다.
		private static final Logger logger = LoggerFactory.getLogger(boardController.class);
		//addBoard 폼 연결
		@RequestMapping(value="addBoard",method=RequestMethod.GET)
		//Mapping 해줘서 value 의 값 받아와서 이제 메서드 진행되는걸로 알고있다. 여기서 GET방식으로  값 받아와서 쭉쭉 진행된다.
		//클래스에 적용한 값과 메서드에 진행될 값을 조합해서 매핑될 경로를 정한다고 한다.
		public String addBoard() {
			logger.debug("Controller addBoard GET");
			// debug , info 등급 말고 상위 등급이 있다고 들었는데 그건 잘 기억이 안나고, debug 는 개발자만 볼려고 개발자 콘솔창에만 보여주는걸 사용할떄 쓴다고 들었다.
			// info 는 일반유저에게도 보여줘야할떄 사용하는 등급이라고 들었다. 
			return "addBoard"; // 포워딩 한것이라고 알고있다. 포워딩과 리다이렉트의 차이에 대해서 검색해보고 내용을 읽어 보았지만 아주 쉽게 알수는 없었다.
			//대강 내가 이해한대로 설명하자면 포워딩 하면 url이 가장 마지막(변경된곳)의 주소가 노출이 되고 리다이렉트하면 노출이 안되는 것으로 알고있다.
		}
		//addBoard 폼 처리
		@RequestMapping(value="addBoard",method=RequestMethod.POST)
		public String addBoard(Model model,BoardRequest boardRequest,HttpSession session) {
		//이부분은 선언해줘서 일단 사용 가능하게 해주는 것으로 보인다.
			logger.debug("Controller addBoard POST");
			logger.debug("boardDTO:"+boardRequest.toString());
			String path = session.getServletContext().getRealPath("/upload");//세션객체의 경로를 가져온다
			int flag=0;
			for(MultipartFile multipartFile : boardRequest.getMultipartFile()) {
				if(multipartFile.getContentType().equals("application/x-msdownload")) {
				// if 문 mulitFile 의 contentType을 get 해와서 같은지 비교해라 application/x-msdownload 가 exe 파일의 파일형인데,
				// exe 파일 즉 실행파일인 경우 업로드가 되지 않게 하고 그렇지 않은 경우는 업로드가 되게 해주는역할을한다.	
					logger.debug("실행파일은 패스");
					flag=1;
					model.addAttribute("flag",flag);
					return "addBoard";
				}
			}
			logger.debug("실행파일이 아니니 성공");
			boardService.addBoard(boardRequest,path); // boardService 안의 addBoard 메서드 안의 boardRequest 경로 요청한다.
			
			return "redirect:/";
		}
		@RequestMapping(value="getBoardList",method=RequestMethod.GET)
		public String getBoardList(Model model) {
			logger.debug("boardController.getBoardList");
			List<Board> list=boardService.getBoardList();
			model.addAttribute("list",list);
			return "getBoardList"; 
		}

	}

*/