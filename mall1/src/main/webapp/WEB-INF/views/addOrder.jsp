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
		<h1>addOrder 주문확인</h1>
		<form action="${pageContext.request.contextPath}/addOrder" method="post">
			<input type="hidden" value="${sessionMemberNo}" id="memberNo" name="memberNo">
			<input type="hidden" value="${itemNo}" id="itemNo" name="itemNo">
			<div class="form-group">
				<label>주문자아이디</label>
					<div class="input-group">
						<input type="text" class="form-control"  value="${sessionMemberId}"  readonly>
					</div>
			</div>
			<div class="form-group">
				<label>상품명</label>
					<div class="input-group">
						<input type="text" class="form-control" value="${itemName}"  readonly>
					</div>
			</div>
			<div class="form-group">
				<label>상품가격</label>
					<div class="input-group">
						<input type="text" class="form-control" value="${itemPrice}"  readonly>
					</div>
			</div>
			<div class="form-group text-center">
				<input type="submit" value="주문완료" class="btn btn-info">
			</div>
		</form>
	</div>
</body>
</html>