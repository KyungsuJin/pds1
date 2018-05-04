<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<script>
	function removeWindow(){
		if(opener != null){
			opener.checkForm = null
			self.close();
		}
	}
	$(document).ready(function(){
		$("#checkBtn").click(function(){
			if($("#memberId").val().length < 4){
				alert("4자 이상 만 생성가능");
			} else{
				$("#memberIdCheckForm").submit();
			}
		});
		
		$("#memberIdAdaptBtn").click(function(){
			var memberId = $("#memberId").val();
			var originalMemberId = $("#originalMemberId").val();
			
			if($("#memberId").val().length < 4){
				alert("4자 이상 만 생성가능");
			} else if(($("#memberIdCheck").val() == 0) || (originalMemberId != memberId)){ 
				alert("아이디 중복체크를 다시 확인해주세요.");
			} else{
				opener.document.memberForm.memberId.value = $("#memberId").val();
				removeWindow();	
			}
		});
		
		$("#cancelBtn").click(function(){
			removeWindow();
		});
		
		if(${empty member.memberId}){
			$("#memberId").val(opener.document.memberForm.memberId.value);
		}
	});
</script>
</head>
<body>
	<br>
	<b>아이디 중복체크</b>
	<form id="memberIdCheckForm" action="" method="post">
		<input type="text" id="memberId" name="memberId" value="${member.memberId}">
		<input type="hidden" id="originalMemberId" value="${member.memberId}">
		<input type="button" id="checkBtn" value="중복확인">
	</form>
	<br>
	<c:choose>	 
		<c:when test="${empty returnMember.memberId}">
			<input type="hidden" id="memberIdCheck" value="1">
			<p>사용할 수 있는 아이디 입니다.</p>
		</c:when>
		<c:otherwise>
			<input type="hidden" id="memberIdCheck" value="0">
			<p>사용할 수 없는 아이디 입니다.</p>
		</c:otherwise>
	</c:choose>
	<input type="button" id="memberIdAdaptBtn" value="아이디 적용">
	<input type="button" id="cancelBtn" value="취소">
</body>
</html>