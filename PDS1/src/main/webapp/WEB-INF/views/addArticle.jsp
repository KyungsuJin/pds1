<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#fileChoose").change(function(e){
				var plusFile = $("#fileChoose").closest("div").clone();
				$("#fileChoose").val("");
				$("#submitFile").before(plusFile);
				$("p").hide();
			});
			
			$("#articleBtn").click(function(){
				if($('#articleTitle').val().length < 1) {
	                alert('title을 입력하세요');
	            } else if($('#articleContent').val().length < 1) {
	                alert('content을 입력하세요');
	            } else{
	                 $('.fileChooseList').each(function(index, item){
	                     if($(this).val().length <1) {
	                         $(this).remove();
	                     }
	                 });
	                 $("#articleForm").submit();
	            }
			});
		});
	</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<form id="articleForm" action="${pageContext.request.contextPath}/addArticle" method="post" enctype="multipart/form-data">
		<div>articleTitle : <input id="articleTitle" type="text" name="articleTitle" value="${article.articleTitle}"></div>
		<div>articleContent : <input id="articleContent" type="text" name="articleContent" value="${article.articleContent}"></div>
		articleTitle
		<c:if test="${!empty exeFileName}">
			<p>경고! exe파일(${exeFileName})입니다.</p>
		</c:if>
		<br>
		<div><input id="fileChoose"class="fileChooseList" type="file" name="multipartFile"></div>
		
		<div id="submitFile"><button id="articleBtn" type="button">보내기</button></div>
	</form>
</body>
</html>