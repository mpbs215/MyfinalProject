<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Main</title>
<style>
.main-member {display:inline-block; line-height:25px;   position:absolute; top:-110px;  background:rgba(255,255,255,0.2); color:#fff; left:30px; height:25px; 
padding:0 10px 0 10px; border-radius:7px; font-size:11px; font-weight:normal; line-height:25px;}

</style>
</head>
<body>
<div class="main-member">
<sec:authorize access="isAuthenticated()">
	<sec:authentication var="mvo" property="principal" /> 
	<p>${mvo.userName}님 환영합니다.</p>
</sec:authorize>
	</div>
	
</body>
</html>