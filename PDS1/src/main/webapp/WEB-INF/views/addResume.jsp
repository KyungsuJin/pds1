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
		/* 이미지 미리보기 스크립트 */
		function readURL(input) { 
			if (input.files && input.files[0]) { 
				var reader = new FileReader(); 
				reader.onload = function (e) { 
					$('#blah').attr('src', e.target.result); 
					} 
				reader.readAsDataURL(input.files[0]); 
				} 
			}
 
	</script>
	<style>
	h4{
		text-align: center;
	}
	#form-div { 
		padding-top: 50px; 
	}
	</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	
	<div id="form-div" class="container">
		<h4>게시글 등록하기</h4><br><br>
		<form class="form-horizontal" name="fileForm" enctype="multipart/form-data">
			<div class="form-group">
				<input type="text" class="form-control" name="resumeTitle"  placeholder="제목을 입력해주세요">
			</div>
			<div class="form-group">
				<textarea name="resumeContent" class="form-control" style="resize: none;" cols="40" rows="8"  placeholder="내용을 입력해주세요"></textarea>
			</div>
			<div>
				<lable>이미지만 등록가능합니다.</lable>
				<input class="btn btn-default" type="file"  onchange="readURL(this);" name="multipartFile">
				<lable>이미지미리보기</lable>
				<img id="blah" src="#"/>
			</div>
			<div>
				<input class="btn pull-right btn-default" type="button" value="등록하기" onclick="javascript:checkFile()">
			</div>
		</form>
	</div>
</body>
</html>