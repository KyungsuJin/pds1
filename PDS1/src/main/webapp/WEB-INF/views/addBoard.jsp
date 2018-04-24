<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
	 	var i = ${flag};
		if(i==1){
			alert('실행파일은 올릴수 없습니다.');
		}
	})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
		<div>boardTitle :   <input type="text" name="boardTitle"></div>
		<div>boardContent : <input type="text" name="boardContent"></div>
		<div>fileUpload :<input type="file" name="multipartFile"></div>
		<div><button type="submit">등록</button></div>
	</form>
</body>
</html>