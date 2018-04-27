<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- page에 java 언어쓰겟다. content는 text와html을 사용하고 유니코드는 utf-8 방식을 쓰겟다. 페이지 인코딩도 utf-8방식을 쓰겠다. -->

<!DOCTYPE html><!-- 문서타입 html -->
<html><!-- 맨처음 나오는  테그 -->
<head><!-- head테그 html 하위에 나오는 테그 -->
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head> <!-- 항상 테그는 열고 닫고 해야하고 열고 닫고 사이의 테그는 한칸 들여쓰고 , 열고바로 닫은뒤 바로 뒤의 테그는 같은 선상에 두는 것으로 알 고 있다. -->
<body><!-- 헤드 다음엔 바디 연속으로도 쓸 수는 있다. tbody 등으로 테이블 밑에 테이브 헤드 테이블 바디도 같은 맥락으로 html 하위에 head 와 body 처럼 table 밑의 헤드와 바디다 -->
	<table border="1" class="table">
		<thead>
			<tr> <!-- 가로줄을 만들어준다 tr th td 각각 쓰임새가 약간씩 다르다 -->
				<th>NoticeId</th> <!-- th는 제목을 입력해주는 쓰임새로 사용한다. -->
				<th>NoticeTitle</th>
				<th>NoticeContent</th>
			</tr>
		</thead>
		<tbody><!-- tbody는 thead와 같은 선상에서 쓰인다. -->
		<c:forEach items="${list}" var="i">	<!-- items는 컬랙션 객체이고, i는 매번 반복될떄마다 바뀌는 변수이다. -->
			<tr>
				<td>${i.noticeId}</td> <!-- 변수 i안의 noticeId를 여기서 사용하기위해서 써준것. -->
			</tr>
		</c:forEach>
		</tbody>
	</table>