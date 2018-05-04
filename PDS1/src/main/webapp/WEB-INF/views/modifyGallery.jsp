<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			$(".addFileBtn").change(function() {
				var addFile = $(".addFileBtn").closest("div").clone();
				$(".div1").before(addFile);
			})
			$("#updateBtn").click(function() {
				console.log("submit하자")
				$("#formAction").submit();
			})
			$("#cancelBtn").click(function() {
				location.href="${pageContext.request.contextPath}/galleryDetail?galleryId=${gallery.galleryId}"
			})
		})
	</script>
	<style>
		#closeBtn{float: none; margin-left: 5px;}
	</style>
</head>
<body>
	<h1>게시글수정</h1>
	<form id="formAction" action="" method="POST">
		<input type="hidden" name="galleryId" value="gallery.galleryId">
		<div>제목 : <input type="text" id="galleryTitle" name="galleryTitle" value="${gallery.galleryId}"></div>
		<div>내용 : <input type="text" id="galleryContent" name="galleryContent" value="${gallery.galleryContent}"></div>
		<div><input type="file" class="addFileBtn" name="multifartFile"></div>	
		<div>
			<c:forEach var="list" items="${gallery.galleryFileList}">
				<div>
					첨부파일 : ${list.galleryFileRealName} / (${list.galleryFileSize}kb)
					<button type="button" class="close" id="closeBtn">x</button>
				</div>	
			</c:forEach>
			
		</div>
		<div class="div1">	
			<button type="button" id="updateBtn">수정하기</button>
			<button type="button" id="cancelBtn">취소</button>
		</div>

	</form>	
</body>
</html>