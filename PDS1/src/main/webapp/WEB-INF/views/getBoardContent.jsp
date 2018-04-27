<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

	<jsp:include page="body.jsp"></jsp:include>
	
	<table border="1" class="table">
			<thead>
				<tr>
					<th>BoardTitle</th>
					<th>BoardContent</th>
					<th>BoardFile</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.boardTitle}</td>
						<td>${board.boardContent}</td>
						<td>
						<c:forEach items="${board.boardFile}" var ="boardFile">
							<li><a href="${pageContext.request.contextPath}/resources/upload/${boardFile.boardFileName}.${boardFile.boardFileExt}" 
									data-toggle="tooltip" data-placement="bottom" title="파일크기:${boardFile.boardFileSize} ,확장자:${boardFile.boardFileExt}" download="${boardFile.originalFileName}">${boardFile.originalFileName}
								</a>
							</li>
						</c:forEach>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>

</body>
</html>
