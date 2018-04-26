<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- page에 java 언어쓰겟다. content는 text와html을 사용하고 유니코드는 utf-8 방식을 쓰겟다. 페이지 인코딩도 utf-8방식을 쓰겠다. -->

<!DOCTYPE html><!-- 문서타입 html -->
<html><!-- 맨처음 나오는  테그 -->
<head><!-- head테그 html 하위에 나오는 테그 -->
	<jsp:include page="header.jsp"></jsp:include>
<!-- 	include 는 가져다가 사용할 수 있게 해주는 것이라고 알 고 있따. 여기서는 page=header.jsp를 가져다 사용한다. -->
</head> <!-- 항상 테그는 열고 닫고 해야하고 열고 닫고 사이의 테그는 한칸 들여쓰고 , 열고바로 닫은뒤 바로 뒤의 테그는 같은 선상에 두는 것으로 알 고 있다. -->
<body><!-- 헤드 다음엔 바디 지금처럼 연속으로도 쓸 수는 있다. tbody 등으로 테이블 밑에 테이브 헤드 테이블 바디도 같은 맥락으로 html 하위에 head 와 body 처럼 table 밑의 헤드와 바디다 -->
	<body>
		<jsp:include page="body.jsp"></jsp:include><!-- body사용 -->
		<div align="center"><!-- 가운데정렬 --> <!-- 역시나 검색해보니 정렬하기 위한 태그이다 "left" ,"center" ,"right" 등이 가능한거 같다. -->
			<h1>NoticeList</h1><!--  검색해 보니 제목의 등급이라고 나온다 h1,h2,h3,h4,h5,h6 등이 있다. 점차 숫자가 높아질수록 하위 등급인듯하다. -->
			<table border="1" class="table"> 
			<!-- border 은 검색해보지 않고 관습적으로 쓰고 알고있기로는 굵기의 숫자를 나타낸 것으로 알고있다. 클래스를 테이블로 해주면 테이블이 생서된다. -->
				<thead>
					<tr><!-- tr과 th 는 상위 하위 메뉴 의 개념으로 알고 있었는데 가로중을 만드는 역할이 tr 이고 th 는 제목을 적는 역할 td 는 셀을 만드는 역할을한다. -->
						<th>NoticeId</th>
						<th>NoticeTitle</th>
						<th>NoticeContent</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "notice" items = "${list}"> <!-- foreach문사용 값은 notice list형식으로 -->
					<!-- 검색해봐도 잘 모르겠고 .. 전에 춘림이형에게 물어봤을떄 for each 문에서 순서만 바뀌어서 비슷한 내용이라고 들었다. -->
						<tr>
							<td>${notice.noticeId}</td><!-- EL의 내장객체 사용 이라는데 쓰는건 그럭저럭 쓰는것 같은데 그냥 방식만 대충알고쓰는듯.. -->
							
							<td><a href="${pageContext.request.contextPath}/">${notice.noticeTitle}</td>
							<!-- 대강 알고 있었는데 자세히 몰랐다. 앵커태그 a 태그 등으로 불리고, href 와 함께 쓰이며 href는 보낼곳 주소를 뒤에 적어주는 것이라고 이해하고있다. -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</body>
</html>