<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="navigation">
	<ul class="top-level">
		<li><a href="#">Home</a>
			<ul class="sub-level">
				<li><a href="#">서비스 안내</a></li>
				<!-- 비회원, 유저일 경우 -->
				<li><a href="#">주차장 예약</a></li>
				<li><a href="#">주차장 등록</a></li>

				<!-- admin일 경우 -->
				<li><a href="#">주차장 관리</a></li>
				<li><a href="#">이용현황</a></li>

				<!-- 로그인이 안 된 경우 -->
				<li><a href="#">로그인</a></li>
				<li><a href="#">회원가입</a></li>

				<!-- 유저로 로그인이 된 경우 -->
				<li><a href="#">로그아웃</a></li>
				<li><a href="#">마이페이지</a></li>

				<!-- 관리자로 로그인 한 경우 -->
				<li><a href="#">로그아웃</a></li>
				<li><a href="#">회원관리</a></li>
			</ul></li>

		<li><a href="${pageContext.request.contextPath}/common/introduce">서비스 소개</a></li>
		<li><a href="${pageContext.request.contextPath}/common/serviceInfo">서비스 이용안내</a></li>
		<li><a href="${pageContext.request.contextPath}/common/terms">서비스 이용약관</a>
		<li><a href="${pageContext.request.contextPath}/common/notice">공지사항</a></li>
		<li><a href="${pageContext.request.contextPath}/common/faq">FAQ</a></li>
		<li><a href="${pageContext.request.contextPath}/common/qna">QNA</a></li>
	</ul>
</div>