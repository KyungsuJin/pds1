<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getResumeFile.jsp</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function(){ //DOM이 준비되고
		 $('#fileForm2').hide();
	    $('#fileForm').click(function(){ // ID가 toggleButton인 요소를 클릭하면
	        var state = $('#fileForm2').css('display'); // state 변수에 ID가 moreMenu인 요소의 display의 속성을 '대입'
	        if(state == 'none'){ // state가 none 상태일경우 
	            $('#fileForm2').show(); // ID가 moreMenu인 요소를 show();
	            function checkFile(){
	    			var fm = document.fileForm;
	    			var fnm = fm.multipartFile;
	    			var ext = fnm.value;
	    				if(!(ext.substr(ext.length-3) == 'jsp'|| ext.substr(ext.length-3) == 'jpg'|| ext.substr(ext.length-3) == 'jpeg')){
	    					alert("jsp/jpg/jpeg 이미지 파일만 올릴 수 있습니다.")
	    					return false;
	    				}
	    				document.fileForm.action="${pageContext.request.contextPath}/updateResumeFile?resumeId=${resumeFile.resumeId}"; 
	    				document.fileForm.method="post";
	    				document.fileForm.submit();
	    		}
	        }else{ // 그 외에는
	            $('#fileForm2').hide(); // ID가 moreMenu인 요소를 hide();         
	        }
	    });
	});
</script>
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
		<div id="fileForm"><a class="btn btn-default btn-block">수정</a></div>
		<div id="fileForm2">
		<form class="form-group" name="fileForm" enctype="multipart/form-data">
			<div>
				<input class="btn btn-default" type="file"  name="multipartFile">
			</div>
			<div>
				<input class="btn btn-default" type="button" value="File Upload" onclick="javascript:checkFile()">
			</div>
		</form>
		</div>
    <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/deleteResumeFile?resumeId=${resumeFile.resumeId}">삭제</a></div>
    <div><a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/getResumeList">글목록</a></div>
</body>
</html>


