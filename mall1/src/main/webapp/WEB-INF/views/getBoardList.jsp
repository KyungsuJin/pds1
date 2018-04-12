<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html">
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			$(".btnAddBoard").click(function() {
				console.log("버튼눌럿다.");
				location.href="${pageContext.request.contextPath}/addBoard";
			})
		})
	</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
		<h1>boardList</h1>
		<table border="1" class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.boardNo} </td>
					<td><a href="${pageContext.request.contextPath}/boardDetailView?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
					<td>${board.memberId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:choose>
		<c:when test="${currentPage eq 1}">
		
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${1}">처음으로</a>
			<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage-1}">이전</a>
		</c:otherwise>
	</c:choose>
	
	
	<c:choose>
		<c:when test="${currentPage eq lastPage}">
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage+1}">다음</a>
			<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${lastPage}">마지막으로</a>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>
	<br>
	<button type="button" class="btnAddBoard">글쓰기</button>
	</div>
	


</body>
</html>

