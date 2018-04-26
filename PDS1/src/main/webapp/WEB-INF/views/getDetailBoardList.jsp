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
					<th>BoardContent</th>
					<th>BoardFile</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.boardFile.boardId}</td>
						<td>${board.board.boardContent}</td>
						<td>${board.boardFileExt}</td>
						<td>${board.boardFileType}</td>
						<td>${board.boardFileSize}</td>
						<td><a href="">${board.originalFileName}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</body>
</html>