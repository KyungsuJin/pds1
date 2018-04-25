<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<h4>addResume</h4>
	<form action="${pageContext.request.contextPath}/addResume" method="post" enctype="multipart/form-data">
		<div>
			resumeTitle : <input type="text" name="resumeTitle" id="resumeTitle">
		</div>
		<div>
			resumeContent : <input type="text" name="resumeContent" id="resumeContent">
		</div>
		<div>
			multipartFile : <input type="file" name="multipartFile" id="multipartFile" accept="image/jpeg">
		</div>
			<button name="submit" type="submit">등록</button>
	</form>
</body>
</html>
