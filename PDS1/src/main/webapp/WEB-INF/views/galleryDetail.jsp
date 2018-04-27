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
		<div>글번호 : ${gallery.galleryId} </div>
		<div>작성자 : 회원1</div>
		<div>글제목 : ${gallery.galleryTitle} </div>
		<div>내용 : ${gallery.galleryContent}</div>
		<div>
			<c:forEach var="list" items="${gallery.galleryFileList}">
				<div>첨부파일 : <a href="${pageContext.request.contextPath}/resources/upload/${list.galleryFileName}.${list.galleryFileExt}" download="${list.galleryFileRealName}">${list.galleryFileRealName}.${list.galleryFileExt} / (${list.galleryFileSize}kb)</a></div>
			</c:forEach>
		</div>
		<div></div>
	</div>
</body>
</html>