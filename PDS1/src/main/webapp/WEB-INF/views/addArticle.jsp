<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<sciprt>
	
		$("#filenames").append("");
	</sciprt>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/addArticle" method="post" enctype="multipart/form-data">
		<div>articleTitle : <input type="text" name="articleTitle"></div>
		<div>articleContent : <input type="text" name="articleContent"></div>
		<div>articleTitle : <input multiple="multiple" type="file" name="multipartFile"></div>
		<div><textarea id="fileNames"></textarea></div>
		<div><button type="submit">보내기</button></div>
	</form>
</body>
</html>