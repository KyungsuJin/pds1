<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getResumeFile.jsp</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function(){ 
		 $('#fileForm2').hide();
	    $('#fileForm').click(function(){ 
	        var state = $('#fileForm2').css('display');
	        if(state == 'none'){
	            $('#fileForm2').show();
	        }else{ 
	            $('#fileForm2').hide();          
	        }
	    });
	});
	 function checkFile(){
			var fm = document.fileForm3;
			var fnm = fm.multipartFile;
			var ext = fnm.value;
				if(!(ext.substr(ext.length-3) == 'jsp'|| ext.substr(ext.length-3) == 'jpg'|| ext.substr(ext.length-3) == 'jpeg')){
					alert("jsp/jpg/jpeg 이미지 파일만 올릴 수 있습니다.")
					return false;
				}
				document.fileForm3.action="${pageContext.request.contextPath}/updateResumeFile?resumeId=${resume.resumeId}"; 
				document.fileForm3.method="post";
				document.fileForm3.submit();
			}
</script>
<style type="text/css">
	h1{
	text-align: center;
	}
	#a {
    height: 400px;
    width: 50%;
    background-color: #D3D3D3;
	text-align: center;
	border-left-style: solid;
	border-right-style: solid;
	}
</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<h1>getResumeFile.jsp</h1>
	<div id="a" class="container">
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
		<div id="fileForm">
			<a class="btn btn-default btn-block">수정</a>
		</div>
		<div id="fileForm2">
		<form class="form-group" name="fileForm3" enctype="multipart/form-data">
			<div>
			<input type="hidden" name="resumeId" value="${resumeFile.resumeId}">
			</div>
			<div>
				<input class="btn btn-default" type="file"  name="multipartFile">
			</div>
			<div>
				<input class="btn btn-default" type="button" value="파일 수정하기" onclick="javascript:checkFile()">
			</div>
		</form>
		</div>
    <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/deleteResumeFile?resumeId=${resumeFile.resumeId}">삭제</a></div>
    <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/getResumeList">글목록</a></div>
</body>
</html>