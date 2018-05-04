<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#containerArticle{ width: 1000px; margin: auto; }
	.fileChooseList { display: inline-block !important; }
	#articleContent { height: 300px; }
</style>
<script>
	var removeFile = function(e){
		e.closest("div").remove();
	}
	
	$(document).ready(function(){
		$("#fileChoose").change(function(e){
			var plusFile = $("#fileChoose").closest("div").clone();
			var deleteFile = "<input id='removeBtn' class='btn btn-default' type='button' value='삭제' onclick='removeFile(this)'>";
			$("#fileChoose").val("");
			$("#submitFile").before(plusFile);
			$('[class=fileChooseList]:last').after(deleteFile);
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
	           	 var flag = true;
	             $('.fileChooseList').each(function(index, item){
	            	 if($(this).val().length <1) {
	                     return true;
	                 }
	            	 var file = this.files[0];
	                 if(file.type == "application/x-msdownload"){
	                	 $("#fileLine").before("<p>경고! exe파일(" + file.name + "입니다.</p><br>");
	                	 flag = false;
	                 }
	             });
	             
	             if(flag){
	            	 $('.fileChooseList').each(function(index, item){
	                	 if($(this).val().length <1) {
	                         $(this).remove();
	                     }
	                 });
	            	 $("#articleForm").submit();
	             }
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
			<div>articleTitle : <input id="articleTitle" class="form-control" type="text" name="articleTitle" value="${article.articleTitle}"></div>
			<div>articleContent : <textarea id="articleContent" class="form-control" name="articleContent" value="${article.articleContent}"></textarea></div>
			<div><input id="fileChoose"class="btn btn-default fileChooseList" type="file" name="multipartFile"></div>
			<input type="hidden" id="fileLine">
			<c:forEach var = "articleFile" items = "${article.articleFile}">
				<div>
					<a href="#" value="${articleFile.articleFileId}">${articleFile.articleFileRealName}</a>
					<input class="btn btn-default removeFile" type="button" value="삭제">
				</div>
			</c:forEach>
			<div id="submitFile">
				<button id="articleBtn" class="btn btn-default" type="button">저장</button>
				<input id="cancelBtn" class="btn btn-default" type="button" value="취소">
			</div>
		</form>
		
	</div>
</body>
</html>