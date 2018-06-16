<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/header.css">

<!-- header link -->	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function logout(){
		document.getElementById("logoutForm").submit();		
	}
</script>
</head>
<body>
<sec:authorize access="isAnonymous()">
	<header id="header">
   	 <div class="container">
      <div id="logo" class="pull-left">
        <h1><a href="#intro" class="scrollto">HEADER</a></h1>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
	          <li class="menu-active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/introduce">서비스 안내</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/userReserve">주차장 예약</a></li>
	          <li><a href="${pageContext.request.contextPath}/seller/sellerParkRegistForm">주차장 등록</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/loginForm">로그인</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/signUpForm">회원 가입</a></li>
        </ul>
      </nav>
    </div>
  </header>
</sec:authorize>
  
<sec:authorize access="isAuthenticated()">  
  	<header id="loginHeader">
   	 <div class="container">
      <div id="logo2" class="pull-left">
        <h1><a href="#intro" class="scrollto">Login-HEADER</a></h1>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
	          <li class="menu-active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/introduce">서비스 안내</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/userReserve">주차장 예약</a></li>
	          <li><a href="${pageContext.request.contextPath}/seller/sellerParkRegistForm">주차장 등록</a></li>
	          <li><a href="javascript:logout();">로그아웃</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/mypage">마이페이지</a></li>
        </ul>
      </nav>
    </div>
  </header>
 </sec:authorize> 
 
 <form id="logoutForm" action="${pageContext.request.contextPath}/user/logout"  method="post" style="display:none">
 	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
 </form>
 
</body>
  