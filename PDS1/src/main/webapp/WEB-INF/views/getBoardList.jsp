<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style>
		h1{
			text-align:center;
		}
		#pageDiv{
			text-align:center;
		}
	</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div style="width:500px"class="center-block clearfix">
		<h1>boardList</h1>
		<table border="1" class="table">
				<thead>
					<tr>
						<th>BoardId</th>
						<th>BoardTitle</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.boardId}</td>
							<td><a href="${pageContext.request.contextPath}/getBoardContent?boardId=${board.boardId}">${board.boardTitle}</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<div><a id="addResume" class="btn btn-default btn-sm pull-right" href="${pageContext.request.contextPath}/addBoard">파일등록</a></div>
			</table>
			<nav>
				<div id="pageDiv">
	  				<ul class="pagination pagination-sm">
	  					<li>
							<c:if test="${currentPage>1}">
								<a href="${pageContext.request.contextPath}/getBoardList?currentPage=1" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage-1}">이전</a>
							</c:if>
						</li>
						<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
							
								<li <c:out value="${currentPage eq i ? 'class=active': ''}"/>><a class="" href="${pageContext.request.contextPath}/getBoardList?currentPage=${i}">${i}</a></li>
							
						</c:forEach>
						<li>
							<c:if test="${lastPage>currentPage}">
								<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage+1}">다음</a>
								<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${lastPage}"><span aria-hidden="true">&raquo;</span></a>
							</c:if>
						</li>
					</ul>
				</div>
			</nav>
	</div>
</body>
</html>