<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
		<h1>ArticleContent</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>${article.articleTitle}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${article.articleContent}</td>
				</tr>
			</tbody>
			<tfoot>
				<c:forEach var = "articleFile" items = "${article.articleFile}">
					<tr>
						<td><a href="${downloadPath}${articleFile.articleFileName}.${articleFile.articleFileExt}" download>${articleFile.articleFileRealName}(${articleFile.articleFileSize}byte)</a></td>
					</tr>
				</c:forEach>
			</tfoot>
		</table>
	</div>
</body>
</html>