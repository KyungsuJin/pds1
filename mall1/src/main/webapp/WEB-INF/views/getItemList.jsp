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
		<h1>getItemList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>카테고리번호</th>
					<th>상품명</th>
					<th>상품가격</th>
					<th>상품주문</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="Item">
						<tr>
							<td>${Item.itemNo}</td>
							<td>${Item.categoryNo}</td>
							<td>${Item.itemName}</td>
							<td>${Item.itemPrice}</td>
							<td><a href ="<c:url value="addOrder?itemNo=${Item.itemNo}&itemName=${Item.itemName}&itemPrice=${Item.itemPrice}"/>">주문하기</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${currentPage>1}">
			<a href="getItemList?currentPage=1">처음으로</a>
			<a href="getItemList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<c:if test="${currentPage<total}">
			<a href="getItemList?currentPage=${currentPage+1}">다음</a>
			<a href="getItemList?currentPage=${total}">마지막으로</a>
		</c:if>
	</div>
</body>
</html>