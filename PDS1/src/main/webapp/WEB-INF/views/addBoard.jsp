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
			if($('.multipartFile').length < 5 ){
				$("#InputDiv").append('<div><input  type="file" name="multipartFile" class="multipartFile" id="inputMultipartFile"></div>');
			}else{
				alert('5개 이상은 추가 할 수 없습니다.')
			}
		})
		$("#removeInputFile").click(function(){
			$("#InputDiv").children().last().remove();
			
		})
		$("#SubmitFile").click(function(){
			if($("#boardTitle").val().length<1){
				alert('title을 입력하세요');
			}else if($(".multipartFile").length==0){
				alert('파일을 한개이상 올려주세요');
			}else{
				var flag = false;
				$(".multipartFile").each(function(index,item){
					if($(this).val()==0) {
						$(this).remove();
						flag = true;
					}
				})
				if(flag){
					alert('파일을 선택하지 않은곳이 있습니다.파일선택을 모두완료해주세요');
				}else{
					$("#addBoardForm").submit();
				}
			}
		})
	})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="body.jsp"></jsp:include>
	<div style="width:200px;" class="center-block clearfix">
		<form id="addBoardForm"action="${pageContext.request.contextPath}/addBoard" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>boardTitle</label>
				<input type="text" name="boardTitle" class="form-control" id="boardTitle">
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
			<div>
				<button type="button" class="btn btn-default"  id="SubmitFile">적용</button>
			</div>
			
		</form>
	</div>
</body>
</html>