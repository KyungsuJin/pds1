<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	getBoardList.jsp
	<table border="1">
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
					<td>${board.boardTitle}</td>
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

</body>
</html>