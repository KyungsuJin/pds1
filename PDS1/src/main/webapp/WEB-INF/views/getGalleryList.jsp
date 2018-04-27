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
		<h1>GalleryList</h1>
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
						<td><a href="${pageContext.request.contextPath}/galleryDetail?galleryId=${gallery.galleryId}">${gallery.galleryTitle}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		lastPage = ${lastPage} 
		flag = ${flag} 
		endPage = ${endPage}
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:choose>
						<c:when test="${startPage != 1}">
							<li><a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${1}">처음으로</a></li>
							<li><a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${startPage-1}">이전</a></li>
						</c:when>
					</c:choose>
					
					<c:if test="${lastPage ne 0}">
						<c:forEach begin="${startPage}" end="${endPage}" var="idx">
							<li <c:out value="${currentPage == idx ? 'class=active' : ''}"/>>
								<a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${idx}">${idx}</a>
							</li>				
						</c:forEach>
					</c:if>	
					<c:choose>
						<c:when test="${flag}">
							<li><a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${endPage+1}">다음</a></li>
							<li><a href="${pageContext.request.contextPath}/getGalleryList?currentPage=${lastPage}">마지막으로</a></li>
						</c:when>
					</c:choose>					
				</ul>
			</div>
		
		</div>
		
		
		
	</div>

</body>
</body>
</html>