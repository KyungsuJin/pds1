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
        $("#multipartFile1").on('change', function(event) {
            var file = event.target.files[0];
            if(file.size>=2*1024*1024) {
            	alert("이미지 파일사이즈는 2MB까지 가능합니다.");
            	$('#multipartFile').val("");
            	$('#multipartFile').focus();
            	 return false;
            }
            if(!file.type.match('image/jp.*')) {
            	alert("jsp/jpg/jpeg 이미지 파일만 올릴 수 있습니다.");
            	$('#multipartFile').val("");
            	$('#multipartFile').focus();
            	 return false;
            }
			if(file.type.match('image/jp.*')) { 	
				var reader = new FileReader(); 
				reader.onload = function (e) { 
					$('#fileimagereader').attr('src', e.target.result); 
					} 
				reader.readAsDataURL(event.target.files[0]);
				filetype = event.target.files[0].type;
				document.getElementById('demo').innerHTML = filetype;
			}
        });
    });
		function check() {
			var file = event.target.files[0];
			if(fileForm3.multipartFile.value == "") {
				alert("파일을 등록해주세요");
				fileForm3.multipartFile.focus();
				return false;
			}
			return true;
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
			<form class="form-group" name="fileForm3" onsubmit="return check()" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/updateResumeFile?resumeId=${resume.resumeId}">
				<div>
					<input type="hidden" name="resumeId" value="${resumeFile.resumeId}">
				</div>
				<div>
					<input class="btn btn-default" type="file" accept="image/jpeg"  id="multipartFile1" name="multipartFile">
				</div>
				<div>
					<p id="demo"></p>
					<img id="fileimagereader" src="#"/>
				</div>
				<div>
					<input class="btn btn-default" type="submit" value="파일 수정하기">
				</div>
			</form>
		</div>
	    <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/deleteResumeFile?resumeId=${resumeFile.resumeId}">삭제</a></div>
	     <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/getResumeList">글목록</a></div>

</body>
</html>