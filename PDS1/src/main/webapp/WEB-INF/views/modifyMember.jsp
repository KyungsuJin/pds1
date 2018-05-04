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
		$(".input-group-addon").hide();
		$("p").hide();
		
		var memberSuccess = function(memberSuccessForm){
			memberSuccessForm.removeClass("text-danger");
			memberSuccessForm.removeClass("has-error");
			memberSuccessForm.find("span").removeClass("glyphicon glyphicon-remove-circle");
			memberSuccessForm.find("p").hide();
			memberSuccessForm.find("span").addClass("glyphicon glyphicon-ok");
			memberSuccessForm.addClass("text-success");
			memberSuccessForm.addClass("has-success");
		}
		
		var memberFail = function(memberFailForm){
			memberFailForm.removeClass("text-success");
			memberFailForm.removeClass("has-success");
			memberFailForm.find("span").removeClass("glyphicon glyphicon-ok");
			memberFailForm.addClass("text-danger");
			memberFailForm.addClass("has-error");
			memberFailForm.find("span").addClass("glyphicon glyphicon-remove-circle");
			memberFailForm.find("p").show();
		}
		
		var percentTotal=0;
		var percentPw=0;
		var percentPwCheck=0;
		
		var percentMerge = function(){
			percentTotal = percentPw+percentPwCheck;
			$(".progress div").width(percentTotal+"%");
		}

		$("#memberPw").blur(function(){
			$(".member-pw span").show();
			if($("#memberPw").val().length < 4){
				memberFail($(".member-pw"));
				percentPw = 0;
			} else {
				memberSuccess($(".member-pw"));
				percentPw = 50;
			}
			percentMerge();
		});
		
		$("#memberPwCheck").blur(function(){
			$(".member-pw-check span").show();
			if(($("#memberPw").val() != $("#memberPwCheck").val()) || ($("#memberPwCheck").val().length < 4)){
				memberFail($(".member-pw-check"));
				percentPwCheck = 0;
			} else {
				memberSuccess($(".member-pw-check"));
				percentPwCheck = 50;
			}
			percentMerge();
		});
		
		$("#memberBtn").click(function(){
			if($("#memberId").val().length < 4 ){
				
			} else if($("#memberPw").val().length < 4 ){
				
			} else if($("#memberPwCheck").val().length < 4 ){
				
			} else{
				$("#memberForm").submit();
			}
			
		});
		
		$("#calcelBtn").click(function(){
			if(${sessionMemberId eq 'admin'}){
				$(location).attr('href', "${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage}&pagePerRow=${pagePerRow}");
			} else{
				$(location).attr('href', "${pageContext.request.contextPath}/");
			}
			
		});
		
		
	});
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerMember" class="col-md-6 col-md-offset-3">
		<h1>addMember</h1>
		<form id="memberForm" name="memberForm" action="${pageContext.request.contextPath}/modifyMember" method="post">
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="pagePerRow" value="${pagePerRows}">
			<div class="form-group member-id">
				<label>아이디</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" id="memberId" name="memberId" placeholder="이름을 입력해 주세요" value="${member.memberId}" readonly>
				</div>
				<p></p>
			</div>
			<div class="form-group member-pw">
				<label>비밀번호</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="비밀번호" value="${member.memberPw}">
				</div>
				<p>비밀번호를 4자 이상 입력 해 주세요</p>
			</div>
			<div class="form-group member-pw-check">
				<label>비밀번호 확인</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="memberPwCheck" name="memberPwCheck" placeholder="비밀번호 확인" value="${member.memberPw}">
				</div>
				<p>비밀번호가 일치하지 않습니다</p>
			</div>
			<div class="progress">
				<div class="progress-bar progress-bar-striped active"
					role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100" style="width: 0%">
					<span class="sr-only">0% Complete</span>
				</div>
			</div>
			<div class="form-group text-center">
				<button type="button" id="memberBtn" class="btn btn-info">수정</button>
				<button type="button" id="calcelBtn" class="btn btn-warning">수정취소</button>
			</div>
		</form>
	</div>
</body>
</html>