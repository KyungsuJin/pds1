<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#containerArticle{ width: 1000px; margin: auto; }
</style>
<script>
	$(document).ready(function(){
		$("#fileChoose").change(function(e){
			var plusFile = $("#fileChoose").closest("div").clone();
			$("#fileChoose").val("");
			$("#submitFile").before(plusFile);
			$("p").hide();
		});
		
		$(".removeFile").click(function(){
			var deleteFile = "<input type='hidden' name='articleDeleteList' value='"+$(this).prev().attr("value")+"'>";
			$("#submitFile").before(deleteFile);
			$(this).closest("div").remove();
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
		
		$("#cancelBtn").click(function(){
			$(location).attr('href', "${pageContext.request.contextPath}/getArticleContent?articleId=${article.articleId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}");
		});
	});
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerArticle" align="center">
		<h1>addArticle</h1>
		<form id="articleForm" action="${pageContext.request.contextPath}/modifyArticle" method="post" enctype="multipart/form-data">
			<input type="hidden" name="articleId" value="${article.articleId}">
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="pagePerRow" value="${pagePerRow}">
			<div>articleTitle : <input id="articleTitle" type="text" name="articleTitle" value="${article.articleTitle}"></div>
			<div>articleContent : <input id="articleContent" type="text" name="articleContent" value="${article.articleContent}"></div>
			articleTitle
			<c:if test="${!empty exeFileName}">
				<p>경고! exe파일(${exeFileName})입니다.</p>
			</c:if>
			<br>
			<div><input id="fileChoose"class="fileChooseList" type="file" name="multipartFile"></div>
			<c:forEach var = "articleFile" items = "${article.articleFile}">
				<div>
					<a href="#" value="${articleFile.articleFileId}">${articleFile.articleFileRealName}</a>
					<input class="removeFile" type="button" value="삭제">
				</div>
			</c:forEach>
			<div id="submitFile"><button id="articleBtn" type="button">저장</button></div>
			<input id="cancelBtn" type="button" value="취소">
		</form>
		
	</div>
</body>
</html>