<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" class="table">
			<thead>
				<tr>
					<th>BoardId</th>
					<th>BoardTitle</th>
					<th>BoardContent</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="i">
			<tr>
						<td>${i.boardId}</td>
					</tr>
			</c:forEach>
				</tbody>
		</table>

</body>
</html>