<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="Item">
		<table border=1>
			<tr>
				<td>${Item.itemName}</td>
				<td>${Item.itemPrice}</td>
			</tr>
		</table>
	</c:forEach>
	<c:if test="${currentPage>1}"><a href="getItemList?currentPage=${currentPage-1}">이전</a></c:if>
	<c:if test="${currentPage<total}"><a href="getItemList?currentPage=${currentPage+1}">다음</a></c:if>
</body>
</html>