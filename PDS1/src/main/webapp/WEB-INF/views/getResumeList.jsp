<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getResumeList.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
	<style>
	th, td{
	text-align: center;
	}
	</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<h1>이력서 리스트</h1>
	<div class="container">
	<div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/addResume">이력서등록하기</a></div>
		<table class="table table-striped form-group">
			<thead>
				<tr>
					<th>ResumeId</th>
					<th>ResumeTitle</th>
					<th>ResumeContent</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="resume" items="${list}">
					<tr>
						<td>${resume.resumeId }</td>
						<td><a href="${pageContext.request.contextPath}/getResumeFileDetail?resumeId=${resume.resumeId}">${resume.resumeTitle}</a></td>
						<td>${resume.resumeContent }</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<nav>
			<ul class="pagination pagination-sm">
				<c:if test="${currentPage > 1}">
					<li>
						<a aria-label="first" href="${pageContext.request.contextPath }/getResumeList?currentPage=1">처음으로</a>
					</li>
				</c:if>

					<li>
					<c:forEach var="i" begin="${firstBlockPage}" end="${lastBlockPage}" step="1">
						<a href="${pageContext.request.contextPath}/getResumeList?currentPage=${i}">${i}</a>				
					</c:forEach>		
					</li>

				<c:if test="${currentPage < lastPage}">
					<li>
						<a aria-label="last" href="${pageContext.request.contextPath}/getResumeList?currentPage=${lastPage}">마지막</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>