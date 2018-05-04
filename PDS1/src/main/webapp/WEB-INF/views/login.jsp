<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.memberForm{width:300px;}
	.input-group{width:100%;}
	.input-group-addon{top:0 !important;}
}
</style>
<jsp:include page="header.jsp"></jsp:include>
<script>
	$(document).ready(function(){
		$("#loginBtn").click(function(){
			if($("#memberId").val().length < 4 ){
				
			} else if($("#memberPw").val().length < 4 ){
				
			} else{
				$("#memberForm").submit();
			}
			
		});
		
		$("#calcelBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/");
		});
		
		
	});
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerMember" class="col-md-3 col-md-offset-4">
		<h1>Login</h1>
		<form id="memberForm" name="memberForm" action="${pageContext.request.contextPath}/login" method="post">
			<div class="form-group member-id">
				<label>아이디</label>
				<div class="input-group">
					<input type="text" class="form-control" id="memberId" name="memberId" placeholder="이름을 입력해 주세요" value="${member.memberId}">
				</div>
			</div>
			<div class="form-group member-pw">
				<label>비밀번호</label>
				<div class="input-group">
					<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="비밀번호" value="${member.memberPw}">
				</div>
			</div>
			<div class="form-group text-center">
				<button type="button" id="loginBtn" class="btn btn-info">로그인</button>
				<button type="button" id="calcelBtn" class="btn btn-warning">취소</button>
			</div>
		</form>
	</div>
</body>
</html>