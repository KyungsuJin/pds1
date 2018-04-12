<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="body.jsp"></jsp:include>
	<div class="col-md-6 col-md-offset-3">
		<h1>Board 글쓰기</h1>
		<form action="${pageContext.request.contextPath}/addBoard" method="post">
			<div class="form-group">
				<label>제목</label>
				<div class="input-group">
					<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목을 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label>내용</label>
				<div class="input-group">
					<textarea  class="form-control" id="boardContent" name="boardContent" placeholder="내용을 입력해 주세요" rows="4" cols="80"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label>작성자</label>
				<span class="input-group">
					<input type="text" id="memberId" name="memberId" placeholder="아이디를 입력해 주세요">
				</span>
			</div>
			<div class="form-group text-center">
				<button type="submit">글쓰기</button>
			</div>
		</form>
	</div>
</body>
</html>