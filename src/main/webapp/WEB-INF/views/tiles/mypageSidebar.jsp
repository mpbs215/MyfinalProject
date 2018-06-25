<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
   prefix="sec"%>

<div id="navigation">
	<ul class="top-level">
		      <li><a href="#">Home</a>
         <ul class="sub-level">
            <li></li>
               <li><a href="${pageContext.request.contextPath}/common/terms">서비스 안내</a></li>
            <sec:authorize access="isAuthenticated()">

               <li><a
                  href="${pageContext.request.contextPath}/user/userReserve">주차장
                     예약</a></li>
               <li><a
                  href="${pageContext.request.contextPath}/seller/sellerParkRegistForm">주차장
                     등록</a></li>
               <li><a href="javascript:logout()">로그아웃</a></li>

            </sec:authorize>


            <sec:authorize access="isAnonymous()">
               <!-- 로그인이 안 된 경우 -->
               <li><a
                  href="${pageContext.request.contextPath}/sign/loginForm">로그인</a></li>
               <li><a
                  href="${pageContext.request.contextPath}/sign/signUpForm">회원가입</a></li>
            </sec:authorize>
            <!-- 유저로 로그인이 된 경우 -->
            <sec:authorize access="isAuthenticated()">
               <li><a
                  href="${pageContext.request.contextPath}/userModifyUserForm">마이페이지</a></li>
            </sec:authorize>
            <!-- 관리자로 로그인 한 경우 -->
            <sec:authorize access="hasRole('ROLE_ADMIN')">
               <li><a
                  href="${pageContext.request.contextPath}/admin/manageUsers">회원관리</a></li>
               <li><a
                  href="${pageContext.request.contextPath}/admin/manageParks">주차장
                     관리</a></li>

            </sec:authorize>
         </ul></li>
			
		<li><a href="${pageContext.request.contextPath}/user/userModifyUserForm">회원정보 수정</a></li>
		<li style="border:0;"><a href="${pageContext.request.contextPath}/user/userMypageReserveList">예약한 주차장</a></li>
	</ul>
</div>