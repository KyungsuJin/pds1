<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			$(".btnUpdate").click(function() {
				$("#boardForm").submit();
			})
			$(".btnDelete").click(function() {
				console.log("삭제고고씽");
				location.href="${pageContext.request.contextPath}/deleteBoard?boardNo=${board.boardNo}";
			})
		})
	</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div class="col-md-6 col-md-offset-3">
		<h1>Board 글상세정보</h1>
		<form id="boardForm" action="${pageContext.request.contextPath}/updateBoard" method="POST">
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			작성일자 : ${board.boardDate}
			<div class="form-group">
				<label>제목</label>
				<div class="input-group">
					<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목을 입력해주세요" value="${board.boardTitle}">
				</div>
			</div>
			<div class="form-group">
				<label>내용</label>
				<div class="input-group">
					<textarea  class="form-control" id="boardContent" name="boardContent" placeholder="내용을 입력해 주세요" rows="4" cols="80" >${board.boardContent}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label>작성자</label>
				<span class="input-group">
					<input type="text" id="memberId" name="memberId" placeholder="아이디를 입력해 주세요" value="${board.memberId}">
				</span>
			</div>
			<div class="form-group text-center">
		        <button type="button" class="btnUpdate">수정</button>
		        <button type="button" class="btnDelete">삭제</button>
			</div>
			
		</form>
	</div>
</body>
</html>