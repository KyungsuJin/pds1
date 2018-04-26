<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getResumeFile.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<h4>getResumeFile.jsp</h4>
	<div class="container">

      <img src="/resources/upload/${resumeFile.resumeFileRealName}">

		<div class="form-group">
			<label>resumeId</label>
			<p>${resumeFile.resumeId}</p>
		</div>
		<div class="form-group">
			<label>resumeFileId</label>
			<p>${resumeFile.resumeFileId}</p>
		</div>
		<div class="form-group">
			<label>resumeFileRealName</label>
			<p>${resumeFile.resumeFileRealName}</p>
		</div>
		<div class="form-group">
			<label>resumeFileType</label>
			<p>${resumeFile.resumeFileType}</p>
		</div>
		<div class="form-group">
			<label>resumeFileSize</label>
			<p>${resumeFile.resumeFileSize}</p>
		</div>
		<div class="form-group">
			<label>resumeFileExt</label>
			<p>${resumeFile.resumeFileExt}</p>
		</div>

	</div>
	<a class="btn btn-default" href="#">수정</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/deleteResumeFile?resumeId=${resumeFile.resumeId}">삭제</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/getResumeList">글목록</a>
</body>
</html>


