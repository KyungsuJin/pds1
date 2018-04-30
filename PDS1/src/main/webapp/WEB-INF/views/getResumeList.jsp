<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getResumeList.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
	<style>
	h4, th, td{
		text-align: center;
	}
	#form{
		padding-top: 50px;
	}

	</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="form" class="container text-center">
		<div id="form-table">
		<table class="table form-group">
		<h4>이력서 리스트</h4><br><br>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="resume" items="${list}">
					<tr>
						<td>${resume.resumeId }</td>
						<td><a href="${pageContext.request.contextPath}/getResumeFileDetail?resumeId=${resume.resumeId}">${resume.resumeTitle}</a></td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<div><a id="addResume" class="btn pull-right btn-default" href="${pageContext.request.contextPath}/addResume">이력서등록하기</a></div>
		<nav>
			<ul class="pagination pagination-sm">
				<c:if test="${currentPage > 10}">
					<li>
						<a aria-label="first" href="${pageContext.request.contextPath }/getResumeList?currentPage=1">&laquo;</a>
					</li>
				</c:if>
				<c:if test="${firstBlockPage > 2}">
					<li>
						<a aria-label="first" href="${pageContext.request.contextPath }/getResumeList?currentPage=${firstBlockPage-1}">&lsaquo;</a>
					</li>
				</c:if>
					<li>
					<c:forEach var="i" begin="${firstBlockPage}" end="${lastBlockPage}" step="1">
						<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${i}">${i}</a>				
					</c:forEach>		
					</li>
				<c:if test="${lastBlockPage < totalBlock}">
					<li>
						<a aria-label="last" href="${pageContext.request.contextPath}/getResumeList?currentPage=${lastBlockPage+1}">&rsaquo;</a>
					</li>
				</c:if>
				<c:if test="${currentPage < lastPage}">
					<li>
						<a aria-label="last" href="${pageContext.request.contextPath}/getResumeList?currentPage=${lastPage}">&raquo;</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
	</div>
</body>
</html>