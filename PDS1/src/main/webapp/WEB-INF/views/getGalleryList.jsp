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
					<th>GalleryId</th>
					<th>GalleryIdTitle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "gallery" items = "${list}">
					<tr>
						<td>${gallery.galleryId}</td>
						<td>${gallery.galleryTitle}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</body>
</html>