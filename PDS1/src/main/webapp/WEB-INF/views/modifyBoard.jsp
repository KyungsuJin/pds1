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
			$("#submitFile").click(function(){//버튼을 클릭하면
				if($("#boardTitle").val().length<1){
					alert('title을 입력하세요');
				}else if($(".childDiv").length==0){// file input 이 div 로 감싸져있기때문에 length로 존재 여부를 확인 할 수 있다. 
					alert('파일을 한개이상은 올려야 합니다.');
				}else{
					var flag = false;
					$(".multipartFile").each(function(index,item){//file input 을 each 문으로 돌면서
						if($(this).val()==0){//만약 file input 의 val 이 0이면
							alert('파일을 등록하지 않은곳이 있습니다.');
							$(this).closest("div").remove();//file input 의 부모 div 를 삭제한다. input이 div 에 감싸져있기때문에
							flag=true;
						}
						var file = this.files[0];//input file 에 파일이 올라오면 정보들을 알수있다.
						if(file.type == "application/x-msdownload"){//만약 해당 파일의 타입이 exe 파일이라면
							flag = true;
						}
						
					})
					if(flag){
						alert('exe파일이 포함되어 있거나 파일을 선택하지 않은곳이 있습니다.파일선택을 모두완료해주세요');
					}else{
						$("#modifyBoard").submit();
					}
				}
			})
			$(document).on("click","#removeAddFile",function(){//동적으로 생성된 input 에는  click 이벤트로는 동작하지않기때문에 on 을사용
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-default"  id="submitFile">수정완료</button>
		</div>
	</form>
</body>
</html>
