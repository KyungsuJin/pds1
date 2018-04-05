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
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/modifyMember?memberNo=${member.memberNo}">수정</a></td>
						<td><a class="changeLink" href="${pageContext.request.contextPath}/removeMember?memberNo=${member.memberNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getMemberAddrList?guestNo=${member.memberNo}">주소추가</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav>
			<ul class="pagination">
			<!-- 현재 페이지의 가장 첫번째  -->
			<fmt:formatNumber value="${startPage}" type="number" var="intStartPage"/>
			<!-- 마지막페이지랑 비교해서 오른쪽화살표 안보여주려고! -->
			<fmt:formatNumber value="${lastPage}" type="number" var="intLastPage"/>
			<!-- 현제페이지를 알아야 범위를지정해서 아래 숫자를 호출 할 수 있음 -->
			<fmt:formatNumber value="${currentPage}" type="number" var="intCurrentPage"/>
			<!-- 이전페이지를 구하기위한 계산식인데, 소수점부분이 존재하면 변환해도 남아있기때문에 아예 .0이 된상태로 변환해야함 그래서 이렇게 길어짐. -->
			<fmt:formatNumber value="${(((intCurrentPage-1)/10)-((intCurrentPage-1)/10%1))*10}" type="number" var="previousPage"/>
			<!-- 다음페이지를 구하기위한 계산식인데, 소수점부분이 존재하면 변환해도 남아있기때문에 아예 .0이 된상태로 변환해야함 그래서 이렇게 길어짐. --> 
			<fmt:formatNumber value="${(((intCurrentPage-1)/10 - ((intCurrentPage-1)/10%1))+1)*10+1}" type="number" var="nextPage"/>
				<c:choose>
					<c:when test="${previousPage eq 0}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${previousPage}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
					</c:otherwise>
				</c:choose>
				<c:set var="doneLoop" value="false"/> 
				<c:forEach var="i" begin="${intStartPage}" end="${intStartPage+9}" step="1">
					<!-- 이건 딱 존재하는 페이지만큼만 아래 숫자를 출력해주기 위해서 break문을 써야하기때문에, 써줌 --> 
					<c:if test="${not doneLoop}"> 
						<c:choose>
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
					<c:when test="${intLastPage < nextPage}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${nextPage}" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
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