<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div class="col-md-6 col-md-offset-3">
		<h1>Category 추가</h1>
		<form action="${pageContext.request.contextPath}/addCategory" method="post">
			<div class="form-group">
				<label>카테고리명</label>
				<div class="input-group">
					<input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="카테고리명을 입력해 주세요">
					</div>
			</div>
			<div class="form-group text-center">
				<input type="submit"  class="btn btn-info" value="카테고리등록">
			</div>
		</form>
	</div>
</body>
</html>