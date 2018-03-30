<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addBoard_comment.jsp</title>
</head>
<body>
	<h1>addBoard_commet.jsp test</h1>
	<form action="${pageContext.request.contextPath }/addBoard_comment" method="Post"></form>
	<div>comment : <input type="text" name="comment_content"></div>
	<button type="submit">입력하기</button>
</body>
</html>