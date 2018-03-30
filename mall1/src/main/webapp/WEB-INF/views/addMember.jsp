<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/addMember">
		memberId : <input type="text" name="memberId"> </br>
		memberPw : <input type="text" name="memberPw">
		<button type="submit"></button>
	</form>
</body>
</html>