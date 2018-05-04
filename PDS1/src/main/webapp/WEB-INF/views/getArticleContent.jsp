<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#removeArticleBtn{ float: right; }
	#modifyArticleBtn{ float: right; }
	#containerArticle{ width: 1000px; margin: auto; }
	#containerArticle div{border: 1px solid #bcbcbc; text-align: left;}
	#articleContent{ height: 500px; }
</style>
<script>
	$(document).ready(function(){
		$("#articleListBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/getArticleList?currentPage=${currentPage}&pagePerRow=${pagePerRow}");
		});
		
		$("#removeArticleBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/removeArticle?articleId=${article.articleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}");
		});
		
		$("#modifyArticleBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/modifyArticle?articleId=${article.articleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}");
		});
	});
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerArticle" align="center">
		<h1>ArticleContent</h1>
		<input id="removeArticleBtn" class="btn btn-default" type="button" value="삭제">
		<input id="modifyArticleBtn" class="btn btn-default" type="button" value="수정">
		<br><br>
		<div>${article.articleId}</div>
		<div>${article.articleTitle}</div>
		<div id="articleContent">${article.articleContent}</div>
		<c:if test="${!empty upArticleId}">
			<div><a href="${pageContext.request.contextPath}/getArticleContent?articleId=${upArticleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">윗글</a></div>
		</c:if>
		<c:if test="${!empty downArticleId}">
			<div><a href="${pageContext.request.contextPath}/getArticleContent?articleId=${downArticleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">아랫글</a></div>
		</c:if>
		<c:forEach var = "articleFile" items = "${article.articleFile}">
			<div>
				<a href="${pageContext.request.contextPath}/resources/upload/${articleFile.articleFileName}.${articleFile.articleFileExt}" download="${articleFile.articleFileRealName}">${articleFile.articleFileRealName}(${articleFile.articleFileSize}byte)</a>
			</div>
		</c:forEach>
		<input id="articleListBtn" class="btn btn-default" type="button" value="목록">
	</div>
</body>
</html>