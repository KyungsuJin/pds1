<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addResume.jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addResume" method="POST">
	<div>
		resumeTitle : <input type="text" name="resumeTitle">
	</div>
	<div>
		resumeContent : <textarea name="resumeContent" rows="5" cols="50"></textarea>
	</div>
	<div>
		multiPartFile : <input type="file" name="multiPartFile">
	</div>
	<button type="submit">등록</button>
	</form>
</body>
</html>