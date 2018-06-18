<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Main</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
	<sec:authentication var="mvo" property="principal" /> 
	<b>${mvo.userName}님 환영합니다.</b><p>
		<p></p>
</sec:authorize>
	
		<sec:authorize access="permitAll">
			<li><a href="${pageContext.request.contextPath}/">메인</a></li>
		</sec:authorize>
		
</body>
</html>