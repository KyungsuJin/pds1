<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h1>게시글상세</h1>
	<div>
		<div>글번호 : ${galleryDetail.galleryId} </div>
		<div>작성자 : 회원1</div>
		<div>글제목 : ${galleryDetail.galleryTitle} </div>
		<div>내용 : ${galleryDetail.galleryContent}</div>
		<div>첨부파일 :
			<c:forEach var="list" items="list">
				${list.galleryFile}
			</c:forEach>
		</div>
		<div></div>
	</div>
	
	
</body>
</html>