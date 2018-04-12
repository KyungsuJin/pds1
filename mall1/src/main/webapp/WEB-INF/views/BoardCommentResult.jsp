<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addBoardCommentResult.jsp</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
	<h1>addBoardCommentResult.jsp</h1>
	<div class="form-group">
		<button type="button" class="btn btn-default">
			<a href="${pageContext.request.contextPath}/addBoardCommentForm?commentNo=${boardComment.commentNo}">댓글등록</a>
		</button>
	</div>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>댓글번호No</th>
				<th>게시글No</th>
				<th>아이디</th>
				<th>댓글내용</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="boardComment" items="${list}">
			<tr>
				<td>
					${boardComment.commentNo}
				</td>
				<td>
					${boardComment.boardNo}
				</td>
				<td>
					${boardComment.memberId}
				</td>
				<td>
					${boardComment.commentContent}
				</td>
				<td>
					<a href="#">수정</a>
				</td>
				<td>
					<a href="#">삭제</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>	
	</table>
	<nav>
		<ul class="pagination">
			<c:if test="${currentPage>1}">
			<li class="page-item">
				<a class="page-link" href="BoardCommentResult?currentPage=${currentPage-1}" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
				<span class="sr-only">이전</span>
				</a>
			</li>
			</c:if>	
		    
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
		   
			<c:if test="${currentPage<lastPage}">
			<li class="page-item">
				<a class="page-link" href="BoardCommentResult?currentPage=${currentPage+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">다음</span>
				</a>
			</li>
			</c:if>
		</ul>
	</nav>
</body>
</html>