<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		
			var i = ${flag+1};	//flag 1 을 주입한것에 + 1 을 더해줘서 2로 만든다.
			if(i==2){ 	// if i가 2일때  => 실행파일형식이면 1+1 해서 2가 된다.
				alert("실행파일은 업로드 불가능합니다.");	//경고창을 띄워준다 alert 의 기능이다.
			}
		$("#addInputFile").click(function)(){ 	// 클릭했을떄"addInputFile"메서드를 기능시킨다. 
			if($('.f').length < 2 ) { // '.f'의 길이가 5보다 작을떄(입력된 파일의 개수가 2보다 작을떄)
				$("#inputDiv").append('<div><input type="file" name="multipartFile" class="f" id="inputMultipartFile"></div>');	
			}else{
				alert("파일을 한개만 올려주세요.")
			}
		})
		$("#removeInputFile").click(function(){
			$("#InputDiv").childern().last().remove();
		})
})
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- meta 요소에서 문서의 초기정보를 나타내는 속성은 http-equiv 속성이다. Content-Type과 charset을 지정해줬다. -->
<title>Insert title here</title> <!--이 jsp의 목적인 입력을 해 달라고 써놧다 -->
</head>
<body>
	<div style="width:200px;" class="center-block clearfix">
		<form action="${pageContext.request.contextPath}/addNotice" method="post" enctype="multipart/form-data">
		<!-- action은 말그대로 무언가 행동을 취하라는 뜻이다. addNotice 의 값은 는 post 방식으로 정보를 넘겨라, enctype 은 인코딩 방식을 지정한다 여기서는 
		application/x-www-form-urlencoded이라는 디폴드 값, text/plain텍스트 방식의 인코딩 이 아닌 multipart/form-data를 사용해서
		파일이름뿐 아니라 파일 내용까지 넘겨주는 방식으로 인코딩을 하였다. -->
			<div class="form-group">
				<label>noticeTitle</label> <!-- 라벨을 사용하는 이유는 텍스트를 선택해도 체크박스등을 선택 할 수있게 하기 위해서 사용한다고 검색해서 나왔다. -->
				<input type="text" name="noticeTitle" class="form-control">
			</div>
			<div class="form-group">
			<label>fileUpload</label>
				<button type="button" class="glyphicon glyphicon-plus" id="addInputFile"> <!-- +모양의 그래픽 아이콘 눌렀을떄 사용하기 위해 id지정--></button>
				<button type="button" class="glyphicon glyphicon-minus" id="removeInputFile"><!-- -모양의 그래픽아이콘 눌렀을떄 사용하기위해 id지정--></button>
				<div id="InputDiv"></div> <!-- 위에서 사용하기 위해서 만들어준것. -->
			</div>
			<div><button type="submit" class="btn btn-default" id="submitFile">등록</button></div>
			<!-- 버튼의 타입을 submit으로 해줬다 button으로 해서 다양한 디자인을 사용해도 좋지만 submit 으로 하면 전송기능을 수행하기 때문에 따로 다른방식으로 지정할 필요가 없다. -->
		</form> 
	</div>
</body>
</html>