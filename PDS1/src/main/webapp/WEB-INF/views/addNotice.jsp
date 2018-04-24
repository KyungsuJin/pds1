<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include><!-- header 가져와 쓴다  -->
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include><!-- body가져와쓴다. -->
	<form action="${pageContext.request.contextPath}/addNotice" method="post" enctype="multipart/form-data">
<!-- pageContext를사용하여 요청한다 contextpath를  /addNotice 를 post 방식으로 enctype은 폼 전송시 데이터 전송방식이고 multipart form-data방식이다 -->
		<div>noticeTitle : <input type="text" name="noticeTitle"> </div>
	<!-- 	noticeTitle 은 input type 은 text 이고 이름은 noticeTitle이라는 것을 사용한다. -->
		<div>noticeContent : <input type="text" name="noticeContent"> </div>
		<!-- 이하동문 -->
		<div>noticeTitle : <input multiple="multiple" type="file" name="multipartFile"> </div>
		<!-- noticeTitle은  multiple 타입 mulitple 이고, 타입은  file이며 이름은multipartfile이다 -->
	</form> 
</body>
</html>