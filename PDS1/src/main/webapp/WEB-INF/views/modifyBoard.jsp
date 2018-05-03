<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<style>
		.multipartFile{
			border:0;
			padding: 0px 0px;
			padding-top: 5px;
		}
		#removeInputFile{
			top:0px;
		}
	
	</style>
	<script>
		$(document).ready(function(){
			$("#removeInputFile").click(function(){
					$("input:checkbox:checked").each(function(index){//check박스를  each() 사용해 for문처럼 돌면서 checked 된부분을 찾아낸다.
						var deleteFile = "<input type='hidden' name='boardDeleteList' value='" + $(this).val() + "'>";//돌면서 hidden input에 체크된 부분의 value 값을 넣어준다.
						$("#tableForDelete").before(deleteFile);//before 함수로  선택한 요소  앞에 deleteFile 내용을 삽입한다.
						$(this).closest("div").remove();//체크된 부분의 바로앞 요소를찾는 함수 closest() 사용하여 div를 제거해준다.
					})
			})
			$("#addInputFile").click(function(){//addInputFile 을 클릭하면
				if($(".childDiv").length<5){//childDiv 클래스의 length 가 5보다작으면 실행
					//parentDiv 안쪽에 append 함수를 사용해 해당내용을 넣어준다.
					$("#parentDiv").append('<div class="form-inline form-group childDiv"><input  type="file" name="multipartFile" class="form-control multipartFile" id="inputMultipartFile"><button type="button" class="form-control btn btn-default glyphicon glyphicon-remove" id="removeAddFile"></button></div>');
				}else{
					alert('5개 이상은 추가 할 수 없습니다.')
				}
			})
			$("#submitFile").click(function(){
				if($("#boardTitle").val().length<1){
					alert('title을 입력하세요');
				}else if($(".childDiv").length==0){
					alert('파일을 한개이상은 올려야 합니다.');
				}else{
					var flag = false;
					$(".multipartFile").each(function(index,item){
						if($(this).val()==0){
							$(this).closest("div").remove();
							flag=true;
						}
					})
					if(flag){
						alert('파일을 선택하지 않은곳이 있습니다.파일선택을 모두완료해주세요');
					}else{
						$("#modifyBoard").submit();
					}
				}
			})
			$(document).on("click","#removeAddFile",function(){
				$("#removeAddFile").closest("div").remove();
			})
		})
	</script>
</head>
<body>

	<jsp:include page="body.jsp"></jsp:include>
	<form  id="modifyBoard" action="${pageContext.request.contextPath}/modifyBoard" method="post" enctype="multipart/form-data">	
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
					<input type="hidden" name="boardId" value="${board.boardId}">
					<tr>
						<td><input type="text" name="boardTitle" id="boardTitle" value="${board.boardTitle}"></td>
						<td><input type="text" name="boardContent" id="boardContent" value="${board.boardContent}"></td>
						<td>
							<div id="parentDiv">
								<c:forEach items="${board.boardFile}" var ="boardFile">
									<div class="childDiv"><input type="checkbox" id="inputChk" value="${boardFile.boardFileId}">${boardFile.originalFileName}</div>
								</c:forEach>
							</div>
						</td>
						<td><a href="${pageContext.request.contextPath}/modifyBoard?boardId=${board.boardId}">수정</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
		
			<button type="button" class="btn btn-default"  id="submitFile">적용</button>
		</div>
	</form>
</body>
</html>
