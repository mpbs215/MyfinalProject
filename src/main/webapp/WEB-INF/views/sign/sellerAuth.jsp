<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>    
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/header2.css" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/header2.css">
<title>접근 권한 실패</title>

<style>
	div{color:white; text-align:center; }
	.member_login{color:yellow;}
	a{color:white;}
	.login-bg {  background:rgba(0,0,0,0.5); text-align:center; }
	.login-form {text-align:center; display:inline-block; margin-bottom:80px; margin-top:80px; margin-right:100px;}
	.error-message {text-align:center; font-weight:bold; font-size:50px;}
	.login-btn {text-align:center; display:inline-block; margin-left:90px;}
	h2 {text-size:300px;}
</style>

</head>
<body>
<sec:authentication var="mvo" property="principal" />
<sec:authorize access="isAuthenticated()">  
<div class="login-bg"  >
<h2>LOG IN PAGE</h2>

<div class="error-message">
	<c:if test="${not empty requestScope.errorMessage}">
		<span style="color:red">${requestScope.errorMessage}</span>
	</c:if>
</div>

<header id="loginHeader">
   	 <div class="container">
      <div id="logo" class="pull-left">
        <a href="${pageContext.request }" class="scrollto">HEADER</a>
      </div>
      <nav id="nav-menu-container">
        <ul class="nav-menu">
	          <li class="menu-active"><a href="${pageContext.request.contextPath}/">HOME</a></li>
	          <li><a href="${pageContext.request.contextPath}/common/introduce">서비스 안내</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/userReserve">주차장 예약</a></li>
	          <li><a href="${pageContext.request.contextPath}/seller/sellerParkRegistForm">주차장 등록</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/logout;">로그아웃</a></li>
	          <li><a href="${pageContext.request.contextPath}/user/userModifyUserForm">마이페이지</a></li>
        </ul>
      </nav>
    </div>
    
    
<!---- 로그인후 판매자인증 영역 --->
	<script>
 $(document).ready(function() {
		
	 $("#authBtn").on("click",function() {
	 	var hpp = $("#hp").val().trim();
	 	var userId22 = $("#userId2").val().trim();
	 	alert(userId22);
	 	
	 		$.ajax({
	 				type:"POST",
	 				url:"${pageContext.request.contextPath}/sign/sendSMS",		
	 				data:"${_csrf.parameterName}=${_csrf.token}&hp="+hpp+"&userId2="+userId22,	
	 				dataType : "text",
	 				success:function(message){	
	 					alert(message);
	 					if(message == "success"){
	 								alert("본인 인증에 성공 하였습니다.")
	 					}else{						
	 								alert("본인 인증에 실패 하였습니다.")
	 								history.go(-1);
	 						}					
	 					}	//callback			
	 				});	//ajax 끝
	 			})		// submit 함수 끝
	 		})	
 </script>
 
 <div class="box1">
        <sec:authentication var="mvo" property="principal" />
	<form action="${pageContext.request.contextPath}/sign/loginForm" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
			<h2 class="login-title">판매자 인증하기</h2>
			<input type="hidden" id="userId2" name="userId2"  value="${mvo.userId}" >
		<p class="hp">핸드폰 번호를 입력해주세요</p><p class="hp-number"><input type="text" id="hp" name="hp" class="hp-number"></p>
		<p class="hp-btn"><input type="button"  id="authBtn" value="2. 인증번호 받기" ></p>
	</form>
	
	<form action="${pageContext.request.contextPath}/sign/authCheck" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<p class="hp"><input type="text" name="authKey" id="authKey" ></p><p class="hp">인증번호를 입력하세요</p>
		<p class="hp-btn"><input type="submit" value="인증하기" id="hp-btn2"></p>
	</form>
	</div>
	
 <!---- //로그인후 판매자인증 영역 끝--->
 
  </header>
  </div>
 </sec:authorize>
 <div style="background-color: rgba(0,0,0,.5)">
	<hr color="red" style="border-top: 2px solid red">
	<p class="small"></p><div class="member_login">회원이 아니십니까??</div> <a href=" ${pageContext.request.contextPath}/sign/signUpForm" >회원가입</a><p>
	<div class="member_login">아이디/비밀번호를 잊어버리셨습니까?</div><a href="${pageContext.request.contextPath}/sign/findId " >아이디 / 비밀번호 찾기</a><p class="small">
 </div>
</body>
</html>