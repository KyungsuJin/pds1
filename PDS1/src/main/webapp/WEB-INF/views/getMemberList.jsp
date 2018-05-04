<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<style>
	#writeMemberBtn{ float: right; }
	#containerMember{ width: 1000px; margin: auto; }
</style>
<script>
	$(document).ready(function(){
		
	});	
</script>
</head>
<body>
	<jsp:include page="body.jsp"></jsp:include>
	<div id="containerMember" align="center">
		<h1>MemberList</h1>
		
		<table border="1" class="table">
			<thead>
				<tr>
					<th>MemberId</th>
					<th>MemberPw</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "member" items = "${list}">
					<tr>
						<td>${member.memberId}</td>
						<td>${member.memberPw}</td>
						<td><a href="${pageContext.request.contextPath}/modifyMember?memberId=${member.memberId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">수정</td>
						<td><a href="${pageContext.request.contextPath}/removeMember?memberId=${member.memberId}&currentPage=${currentPage}&pagePerRow=${pagePerRow}">삭제</td>
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
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${firstPage}" aria-label="First"> <span aria-hidden="true">&laquo;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${beforePage}" aria-label="Previous"> <span aria-hidden="true">&lt;</span></a></li>
					</c:otherwise>
				</c:choose>
				<c:set var="doneLoop" value="false"/>
				<c:forEach var="i" begin="${beforePage+1}" end="${afterPage-1}" step="1">
					<c:if test="${not doneLoop}"> 
						<c:choose>
							<c:when test="${i eq currentPage && (i eq lastPage || lastPage eq 0)}">
								<li class="active"><a>${i}</a></li>
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:when test="${i eq currentPage}">
								<li class="active"><a>${i}</a></li>
							</c:when>
							<c:when test="${i eq lastPage}">
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
								<c:set var="doneLoop" value="true"/>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				
				<c:choose>
					<c:when test="${lastPage < afterPage}">
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${afterPage}" aria-label="Next"> <span aria-hidden="true">&gt;</span></a></li>
						<li><a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}" aria-label="Last"> <span aria-hidden="true">&raquo;</span></a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>

</body>
</html>