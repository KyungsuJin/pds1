<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addGallery" method="POST" enctype="multipart/form-data">
		<div>galleryTitle : <input type="text" name="galleryTitle"></div>
		<div>galleryContent : <input type="text" name="galleryContent"></div>
		<div>fileUpload : <input multiple="multiple" id="file" type="file" name="multipartFile"></div>
		<div><button type="submit">등록</button></div>	   
		<div id="preview"></div>     
	</form>
	
</body>
</html>