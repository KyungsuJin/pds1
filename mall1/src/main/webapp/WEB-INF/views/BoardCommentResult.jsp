<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addBoardCommentResult.jsp</title>
</head>
<body>
	<h1>addBoardCommentResult.jsp test</h1>
	<table border="1">
		<thead>
			<tr>
				<th>
					No
				</th>
				<th>
					아이디
				</th>
				<th>
					댓글내용
				</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="boardComment" items="${result}">
			<tr>
			<td>
			${boardComment.boardNo}
			</td>
			<td>
			${boardComment.memberId}
			</td>
			<td>
			${boardComment.commentContent}
			</td>
			</tr>
			</c:forEach>
		</tbody>	
	</table>

</body>
</html>