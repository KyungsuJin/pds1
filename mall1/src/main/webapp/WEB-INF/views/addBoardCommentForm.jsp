<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addBoardComment.jsp</title>
</head>
<body>
	<h1>addBoardComment.jsp test</h1>
	<form action="${pageContext.request.contextPath}/addBoardCommentForm" method="Post">
		<div> no : <input type="text" name="boardNo"></div>
		<div> id : <input type="text" name="memberId"></div>
		<div> comment : <input type="text" name="commentContent"></div>
		<button type="submit">댓글 추가</button>
	</form>
</body>
</html>