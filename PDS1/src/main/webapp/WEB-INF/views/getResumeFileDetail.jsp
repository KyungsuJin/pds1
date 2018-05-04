<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getResumeFile.jsp</title>
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function(){ 
		 $('#fileForm2').hide();
		 $('#filedetail').hide();
	    $('#fileForm').click(function(){ 
	        var state = $('#fileForm2').css('display');
	        if(state == 'none'){
	            $('#fileForm2').show();
	        }else{ 
	            $('#fileForm2').hide();          
	        }
	    });
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
	    $("#buttonlist").click(function() {  
	    	location.href="${pageContext.request.contextPath}/getResumeList";
	    });
	    $("#buttondelete").click(function() {  
	    	location.href="${pageContext.request.contextPath}/deleteResumeFile?resumeId=${resumeFile.resumeId}";
	    });

	    $("#buttonfile").click(function() {  
	    	 var state = $('#filedetail').css('display');
		        if(state == 'none'){
		            $('#filedetail').show();
		        }else{ 
		            $('#filedetail').hide();          
		        }
	    });
    });
    function check() {
    	if(fileForm3.resumeTitle.value == "") {
			alert("제목을 입력해주세요.");
			fileForm3.resumeTitle.focus();
			return false;
    	  }
		else if(fileForm3.resumeContent.value == "") {
			alert("내용을 입력해주세요.");
			fileForm3.resumeContent.focus();
			return false;
		}else if(fileForm3.multipartFile.value == "") {
			alert("파일을 등록해주세요");
			fileForm3.multipartFile.focus();
			return false;
		}
		return true;
	}	
</script>
<style type="text/css">
	#detailBoard {
	text-align: center;
	}
	h4{
	text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="form-div" class="container">
		<h4>게시글 상세보기</h4><br><br>
		<table class="table" id="detailBoard">
			<tr>
				<td>작성일</td>
				<td>${resume.resumeDate }</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${resume.resumeId }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${resume.resumeTitle }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${resume.resumeContent }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><a type="button" id="buttonfile">${resumeFile.resumeFileRealName}</a></td>

			</tr>
		</table>
			<div id="filedetail">
				<div>${resumeFile.resumeFileId}</div>
				<div>${resumeFile.resumeFileSize}</div>
				<div>${resumeFile.resumeFileExt}</div>
			</div>
	</div>
	<div class="container">
		<div id="fileForm">
			<input class="btn btn-default btn-sm" type="button" value="수정">
		</div>
		<div id="fileForm2">
			<form class="form-group" name="fileForm3" onsubmit="return check()" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/updateResumeFile?resumeId=${resume.resumeId}">
				<div>
					<input type="hidden" name="resumeId" value="${resumeFile.resumeId}">
				</div>
			<div class="form-group">
				<input type="text" class="form-control" name="resumeTitle"  placeholder="${resume.resumeTitle}">
			</div>
			<div class="form-group">
				<textarea name="resumeContent" class="form-control" style="resize: none;" cols="40" rows="8"  placeholder="${resume.resumeContent }"></textarea>
			</div>
				<div>
					<input class="btn btn-default btn-sm" type="file" accept="image/jpeg"  id="multipartFile" name="multipartFile">
				</div>
				<div>
					<p id="demo"></p>
					<img id="fileimagereader" src="#"/>
				</div>
				<div>
					<input class="btn btn-default btn-sm " type="submit" value="파일 수정하기">
				</div>
			</form>
		</div>
	</div>
	<div class="container">
	    <div>
	   		<input class="btn btn-default btn-sm pull-right" type="button" id="buttondelete" value="삭제">
	   	</div>
	    <div>
			<input class="btn btn-default btn-sm pull-right" type="button" id="buttonlist" value="글목목으로 돌아가기">
		</div>
		<div id="next-prev">
			<c:if test="${nextArticle != null }">
			<p>다음글 : <a href="javascript:goView('${nextResume.resumeNo }')">${nextArticle.title }</a></p>
			</c:if>
			<c:if test="${prevArticle != null }">
			<p>이전글 : <a href="javascript:goView('${prevArticle.articleNo }')">${prevArticle.title }</a></p>
			</c:if>
		</div>
	</div>
</body>
</html>