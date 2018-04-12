<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addBoardComment.jsp</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
	<h1>addBoardComment.jsp test</h1>
		<div class="container">
			<form id="modifyForm" action="${pageContext.request.contextPath}/addBoardCommentForm" method="Post">
			
				<div class="form-group"> 
				boardNo :
				<input class="form-control" type="text" name="boardNo">
				</div>
				
				<div class="form-group">
				 id : 
				 <input class="form-control" type="text" name="memberId">
				 </div>
				 
				<div class="form-group"> 
				comment :
				<textarea class="form-control" id="commentContent" name="commentContent" rows="5" cols="50">${boardComment.commentContent}</textarea>
				</div>
				
				<button class="btn btn-primary btn-lg btn-block" type="submit">댓글 추가</button>
				
			</form>
			
			<button class="btn btn-default btn-lg btn-block" type="button"><a href="${pageContext.request.contextPath}/BoardCommentResult">댓글리스트로 돌아가기</a></button>
		</div>
	</div>
</body>
</html>