<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		
			var i = ${flag+1};
			if(i==2){
				alert('실행파일은 올릴수 없습니다.');
			}
		$("#addInputFile").click(function(){
			if($('.f').length < 5 ){
				$("#InputDiv").append('<div><input  type="file" name="multipartFile" class="f" id="inputMultipartFile"></div>');
			}else{
				alert('5개 이상은 추가 할 수 없습니다.')
			}
		})
		$("#removeInputFile").click(function(){
			$("#InputDiv").children().last().remove();
			
		})
	})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width:200px;" class="center-block clearfix">
		<form action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>boardTitle</label>
				<input type="text" name="boardTitle" class="form-control">
			</div>
			<div class="form-group">
				<label>boardContent</label>
				<input type="text" name="boardContent" class="form-control">
			</div>
			
			<div class="form-group">
			<label>fileUpload</label>
				<button type="button" class="glyphicon glyphicon-plus" id="addInputFile"></button>
				<button type="button" class="glyphicon glyphicon-minus" id="removeInputFile"></button>
				<div id="InputDiv"></div>
			</div>
			<div><button type="submit" class="btn btn-default" id="submitFile">등록</button></div>
		</form>
	</div>
</body>
</html>