<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar  navbar-inverse" style="margin-bottom: 0;">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Member</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/getMemberList.jk" data-toggle="tooltip" data-placement="bottom"
					title="memberList">memberList</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="기능을">메뉴2</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="넣으면">메뉴3</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="좋을까?">메뉴4</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="흠">메뉴5</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty memberId}">
							<li><a href="${pageContext.request.contextPath}/addMember">회원가입</a></li>
							<li><a href="#" data-toggle="modal" data-target="#login-modal">로그인</a></li>
						</c:when>
						
						<c:when test="${memberId ne 'admin'}">
							<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
						</c:when>
						
						<c:otherwise>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">관리<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">기능1</a></li>
									<li><a href="#">기능2</a></li>
									<li class="divider"></li>
									<li><a href="#">Member 정보 수정</a></li>
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>	
						</c:otherwise>
					</c:choose>
				</ul>
				<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true"
					style="display: none;">
					<div class="modal-dialog">
						<div class="loginmodal-container">
							<h1>로그인</h1>
							<br>
							<form id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
								<input type="text" name="memberId" placeholder="Id"> 
								<input type="password" name="memberPw" placeholder="Password">
								<input type="button" id="loginBtn" name="loginBtn" class="login loginmodal-submit" value="로그인">
							</form>
						</div>
					</div>
				</div>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>