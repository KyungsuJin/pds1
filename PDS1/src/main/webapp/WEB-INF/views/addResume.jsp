<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addResume.jsp</title>
	<jsp:include page="header.jsp"></jsp:include>
	<script type="text/javascript">
	$(document).ready(function(){ 
        $("#multipartFile").on('change', function(event) {
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
        
    	    $("#btnReset").click(function() {  
    	         $("form").each(function() {  
    	            this.reset();  
    	         });  
    	    }); 
        });
    function check() {
    	if(fileForm.resumeTitle.value == "") {
			alert("제목을 입력해주세요.");
			fileForm.resumeTitle.focus();
			return false;
    	  }
		else if(fileForm.resumeContent.value == "") {
			alert("내용을 입력해주세요.");
			fileForm.resumeContent.focus();
			return false;
		}else if(fileForm.multipartFile.value == "") {
			alert("파일을 등록해주세요");
			fileForm.multipartFile.focus();
			return false;
		}
		return true;
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
		<form class="form-group" name="fileForm" id="fileformid" onsubmit="return check()" enctype="multipart/form-data" action="${pageContext.request.contextPath}/addResume" method="post">
			<div class="form-group">
				<input type="text" class="form-control" name="resumeTitle"  placeholder="제목을 입력해주세요">
			</div>
			<div class="form-group">
				<textarea name="resumeContent" class="form-control" style="resize: none;" cols="40" rows="8"  placeholder="내용을 입력해주세요"></textarea>
			</div>
			<div>
				<lable>이미지만 등록가능합니다.</lable>
				<input class="btn btn-default" type="file" accept="image/jpeg" id="multipartFile" name="multipartFile">
			</div>
			<div>
				<lable>이미지미리보기</lable>
				<p id="demo"></p>
				<img id="fileimagereader" src="#"/>
			</div>
			<div id="file-div2">
				<input class="btn pull-right btn-default" type="submit" value="등록하기">
			</div>
			<div>
				<input class="btn pull-right btn-default" type="button" id="btnReset" value="다시작성하기">
			</div>
		</form>
	</div>
</body>
</html>