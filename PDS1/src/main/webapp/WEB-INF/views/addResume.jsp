<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
	<script type="text/javascript">

	/* 파일형식을 체크하는 스크립트 */
		function checkFile(){
			var fm = document.fileForm;
			var fnm = fm.multipartFile;
			var ext = fnm.value;
				if(!(ext.substr(ext.length-3) == 'jsp'|| ext.substr(ext.length-3) == 'jpg'|| ext.substr(ext.length-3) == 'jpeg')){
					alert("jsp/jpg/jpeg 이미지 파일만 올릴 수 있습니다.")
					return false;
				}
				document.fileForm.action="${pageContext.request.contextPath}/addResume"; 
				document.fileForm.method="post";
				document.fileForm.submit();
		}
	</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<h4>이미지 파일만 등록할 수 있습니다.</h4>
	<div>
		<form class="form-group" name="fileForm" enctype="multipart/form-data">
			<div>
				<label>resumeTitle :</label> 
				<input type="text" name="resumeTitle">
			</div>
			<div>
				<label>resumeContent :</label> 
				<input type="text" name="resumeContent">
			</div>
			<div>
				<label>multipartFile :</label>
				<input class="btn btn-default" type="file" name="multipartFile">
			</div>
			<div>
				<input class="btn btn-default" type="button" value="File Upload" onclick="javascript:checkFile()">
			</div>
		</form>
	</div>
</body>
</html>
