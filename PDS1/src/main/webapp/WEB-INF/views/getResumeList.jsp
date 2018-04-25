<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getResumeList.jsp</title>
</head>
<body>
	<h1>이력서 리스트</h1>
	<table>
		<thead>
			<tr>
				<th>ResumeId</th>
				<th>ResumeTitle</th>
				<th>ResumeContent</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="resume" items="${list}">
				<tr>
					<th>${resume.resumeId }</th>
					<th><a href="${pageContext.request.contextPath}/getResumeFile?resumeId=${resume.resumeId}">${resume.resumeTitle}</a></th>
					<th>${resume.resumeContent }</th>
				</tr>
			</c:forEach>
		</tbody>	
		
	</table>
</body>
</html>