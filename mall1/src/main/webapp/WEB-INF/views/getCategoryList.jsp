<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
		<h1>getCategoryList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>카테고리명</th>
					<th>상품등록</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="category">
					<tr>
						<td>${category.categoryNo}</td>
						<td>${category.categoryName}</td>
						<td><a href="addItem?categoryNo=${category.categoryNo}">등록</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${currentPage>1}">
			<a href="getCategoryList?currentPage=1">처음으로</a>
			<a href="getCategoryList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<c:if test="${currentPage<lastPage}">
			<a href="getCategoryList?currentPage=${currentPage+1}">다음</a>
			<a href="getCategoryList?currentPage=${lastPage}">마지막으로</a>
		</c:if>
		</div>
</body>
</html>