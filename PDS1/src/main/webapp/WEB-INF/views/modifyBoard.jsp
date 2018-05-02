<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#removeInputFile").click(function(){
					$("input:checkbox:checked").each(function(index){//check박스를  each() 사용해 for문처럼 돌면서 checked 된부분을 찾아낸다.
						var deleteFile = "<input type='hidden' name='boardDeleteList' value='" + $(this).val() + "'>";//돌면서 hidden input에 체크된 부분의 value 값을 넣어준다.
						$("#tableForDelete").before(deleteFile);//before 함수로  선택한 요소  앞에 deleteFile 내용을 삽입한다.
						$(this).closest("div").remove();//체크된 부분의 바로앞 요소를찾는 함수 closest() 사용하여 div를 제거해준다.
					})
			})
			$("#addInputFile").click(function(){
				if($(".divchk").length<5){
					$("#checkboxDiv").append('<div class="divchk" id="checkboxDiv"><input  type="file" name="multipartFile" class="multipartFile" id="inputMultipartFile"></div>');
				}else{
					alert('5개 이상은 추가 할 수 없습니다.')
				}
				
			})
		})
	</script>
</head>
<body>

	<jsp:include page="body.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/modifyBoard" method="post" enctype="multipart/form-data">	
		<table id="tableForDelete" border="1" class="table">
			<thead>
				<tr>
					<th>BoardTitle</th>
					<th>BoardContent</th>
					<th>BoardFile 
						<button type="button" class="glyphicon glyphicon-plus" id="addInputFile"></button>
						<button type="button" class="glyphicon glyphicon-minus" id="removeInputFile" ></button></th>
					<th>수정</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${list}" var="board">
					<tr>
						<td><input type="text" name="boardTitle" value="${board.boardTitle}"></td>
						<td><input type="text" name="boardContent" value="${board.boardContent}"></td>
						<td>
						<c:forEach items="${board.boardFile}" var ="boardFile">
							<div><div class="divchk"id="checkboxDiv"><input type="checkbox" id="inputCheck"name="boardFileId" value="${boardFile.boardFileId}">${boardFile.originalFileName}</div></div>
						</c:forEach>
						</td>
						<td><a href="${pageContext.request.contextPath}/modifyBoard?boardId=${board.boardId}">수정</a></td>
					</tr>
				</c:forEach>
				<input type="submit" value="수정완료">
			</tbody>
		</table>
		
	</form>
</body>
</html>
