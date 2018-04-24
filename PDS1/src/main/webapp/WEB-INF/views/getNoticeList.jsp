<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include><!-- header사용 -->
</head>
<body>
	<body>
		<jsp:include page="body.jsp"></jsp:include><!-- body사용 -->
		<div align="center"><!-- 가운데정렬 -->
			<h1>NoticeList</h1>
			<table border="1" class="table">
				<thead>
					<tr>
						<th>NoticeId</th>
						<th>NoticeTitle</th>
						<th>NoticeContent</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "notice" items = "${list}"> <!-- foreach문사용 값은 notice list형식으로 -->
						<tr>
							<td>${notice.noticeId}</td>
							<td><a href="${pageContext.request.contextPath}/">${notice.noticeTitle}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</body>
</html>