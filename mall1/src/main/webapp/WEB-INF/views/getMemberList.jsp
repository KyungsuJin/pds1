<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div align="center">
		<h1>memberList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>멤버 순서</th>
					<th>멤버 이름</th>
					<th>멤버 비번</th>
					<th>수정</th>
					<th>삭제</th>
					<th>멤버 주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "member" items = "${list}">
					<tr>
						<td>${member.memberNo}</td>
						<td>${member.memberId}</td>
						<td>${member.memberPw}</td>
						<td><a href="${pageContext.request.contextPath}/modifyMember?memberNo=${member.memberNo}">수정</a></td>
						<td><a class="changeLink" href="${pageContext.request.contextPath}/removeMember?memberNo=${member.memberNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getMemberAddrList?guestNo=${member.memberNo}">주소추가</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav>
			<ul class="pagination">
				<c:choose>
					<c:when test="${beforePage eq 0}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=1" aria-label="First"> <span aria-hidden="true">&laquo;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${beforePage}" aria-label="Previous"> <span aria-hidden="true">&lt;</span></a></li>
					</c:otherwise>
				</c:choose>
				<c:set var="doneLoop" value="false"/>
				<!-- beforePage는 이전으로가는것이고, nextPage는 다음페이지로 가는것이니까 서로 +1 -1만 해주면 범위가 정해진다. -->
				<c:forEach var="i" begin="${beforePage+1}" end="${nextPage-1}" step="1">
					<!-- 이건 딱 존재하는 페이지만큼만 아래 숫자를 출력해주기 위해서 break문을 써야하기때문에, 써줌 --> 
					<c:if test="${not doneLoop}"> 
						<c:choose>
							<c:when test="${i eq currentPage && i eq lastPage}">
								<li class="active"><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:when test="${i eq currentPage}">
								<li class="active"><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
							</c:when>
							<c:when test="${i eq lastPage}">
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
								<!-- 이건 break대용잉! --> 
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				
				<c:choose>
					<c:when test="${lastPage < nextPage}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${nextPage}" aria-label="Next"> <span aria-hidden="true">&gt;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}" aria-label="Last"> <span aria-hidden="true">&raquo;</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	getMemberList.jsp
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비번</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="member" items="${list}">			
				<tr>
					<td>${member.memberNo}</td>
					<td>${member.memberId}</td>
					<td>${member.memberPw}</td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>
</body>
</html> --%>