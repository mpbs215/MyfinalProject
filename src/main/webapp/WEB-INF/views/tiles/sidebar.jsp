<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<div id="navigation">
	<ul class="top-level">
		<li><a href="#">Home</a>
			<ul class="sub-level">
				<li><a href="#">서비스 안내</a></li>
				<li><a href="#">주차장 예약</a></li>
				<li><a href="#">주차장 등록</a></li>

				<sec:authorize access="Admin">
					<!-- admin일 경우 -->
					<li><a href="#">주차장 관리</a></li>
					<li><a href="#">이용현황</a></li>
					<!-- 관리자로 로그인 한 경우 -->
					<li><a href="#">회원관리</a></li>
				</sec:authorize>

				<!-- 로그인이 안 된 경우 -->
				<sec:authorize access="isAnonymous()">
					<li><a href="${pageContext.request.contextPath}/sign/loginForm">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/sign/signUpForm">회원가입</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<!-- 유저로 로그인이 된 경우 -->
				<li><a href="javascript:logout();">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/user/userModifyUserForm">마이페이지</a></li>
				</sec:authorize>

			


			</ul></li>

		<li><a href="#">About us</a></li>
		<li><a href="#">Contact</a></li>
		<li><a href="#">Portfolio</a>
		<li><a href="#">Contact us</a></li>
		<li><a href="#">Feedback</a></li>
	</ul>
</div>