<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardTable.css">

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

<!-- 로그인한 유저 아이디 담아둠 -->
<sec:authentication var="mvo" property="principal" />
</head>
<body id="login-auth">
	<!-----로그인전 ---->
 <sec:authorize access="isAnonymous()">
<header id="header">
   	 <div class="container">
      <div id="logo" class="pull-left">
        <a href="#intro" class="scrollto">HEADER</a>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
	          <li class="menu-active"><a href="${pageContext.request.contextPath}/">HOME</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/introduce">서비스 안내</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/userReserve">주차장 예약</a></li>
	          <li><a href="${pageContext.request.contextPath}/seller/sellerParkRegistForm">주차장 등록</a></li>
	          <li><a href="${pageContext.request.contextPath}/sign/loginForm">로그인</a></li>
	          <li><a href="${pageContext.request.contextPath}/sign/signUpForm">회원 가입</a></li>
        </ul>
      </nav>
    </div>
  </header>
  </sec:authorize>
	  <!-----로그인전 ---->

  <!-- 로그인후 ---->
<sec:authorize access="isAuthenticated()">  
  	<header id="loginHeader">
   	 <div class="container">
      <div id="logo" class="pull-left">
        <a href="#intro" class="scrollto">HEADER</a>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
	          <li class="menu-active"><a href="${pageContext.request.contextPath}/">HOME</a></li>
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
 <!-- //로그인후 ---->
 
		 <form id="logoutForm" action="${pageContext.request.contextPath}/user/logout"  method="post" style="display:none">
		 	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		 </form>
	</body>
 </html>