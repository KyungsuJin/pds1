<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#writeArticleBtn{ float: right; }
	#containerArticle{ width: 1000px; margin: auto; }
</style>
<script>
	$(document).ready(function(){
		$("#writeArticleBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/addArticle?currentPage=${currentPage}&pagePerRow=${pagePerRow}");
		});
	});	
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerArticle" align="center">
		<h1>ArticleList</h1>
		
		<input id="writeArticleBtn" class="btn btn-default" type="button" value="글쓰기">
		<table border="1" class="table">
			<thead>
				<tr>
					<th>ArticleId</th>
					<th>ArticleTitle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "article" items = "${list}">
					<tr>
						<td>${article.articleId}</td>
						<td><a href="${pageContext.request.contextPath}/getArticleContent?articleId=${article.articleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">${article.articleTitle}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav>
			<ul class="pagination">
				<c:choose>
					<c:when test="${beforePage eq 0}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${firstPage}" aria-label="First"> <span aria-hidden="true">&laquo;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${beforePage}" aria-label="Previous"> <span aria-hidden="true">&lt;</span></a></li>
					</c:otherwise>
				</c:choose>
				<c:set var="doneLoop" value="false"/>
				<c:forEach var="i" begin="${beforePage+1}" end="${afterPage-1}" step="1">
					<c:if test="${not doneLoop}"> 
						<c:choose>
							<c:when test="${i eq currentPage && (i eq lastPage || lastPage eq 0)}">
								<li class="active"><a>${i}</a></li>
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:when test="${i eq currentPage}">
								<li class="active"><a>${i}</a></li>
							</c:when>
							<c:when test="${i eq lastPage}">
								<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${i}">${i}</a></li>
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				
				<c:choose>
					<c:when test="${lastPage < afterPage}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${afterPage}" aria-label="Next"> <span aria-hidden="true">&gt;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getArticleList?currentPage=${lastPage}" aria-label="Last"> <span aria-hidden="true">&raquo;</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>

</body>
</html>