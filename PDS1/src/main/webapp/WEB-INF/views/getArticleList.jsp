<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
		<h1>ArticleList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>ArticleId</th>
					<th>ArticleTitle</th>
					<th>ArticleContent</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "article" items = "${list}">
					<tr>
						<td>${article.articleId}</td>
						<td><a href="${pageContext.request.contextPath}/">${article.articleTitle}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</body>
</html>