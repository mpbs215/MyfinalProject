<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_signUpForm.css">
<title>Log In</title>

<style>
	div{color:white; text-align:center; }
	.member_login{color:yellow;}
	a{color:white;}
	.login-bg { background:rgba(0,0,0,0.5); text-align:center; width:800px; display:inline-block; margin-left:280px; margin-bottom:180px; margin-top:80px;}
	 .login-form {text-align:center; display:inline-block; margin-right:100px; } 
	.error-message {text-align:center; font-weight:bold; font-size:50px;}
	.login-btn {text-align:center; display:inline-block; margin-left:90px;}
	h2 {text-size:300px;}
</style>

</head>
<body>
<div class="login-bg"  >
<h2>LOG IN PAGE</h2>

<div class="error-message">
	<c:if test="${not empty requestScope.errorMessage}">
		<span style="color:red">${requestScope.errorMessage}</span>
	</c:if>
</div>

<div class="login-form">
<form action="${pageContext.request.contextPath}/login" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<table style="width:200px">
					<tr>
						<td>ID</td>
						<td><input type="text" name="userId" size="30" ></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="password" name="password" size="31"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"  class="login-btn" value="로그인"></td>
					</tr>
				</table>
	</form>
</div>	

	<hr color="red">
	<p class="small"></p><div class="member_login">회원이 아니십니까??</div> <a href=" ${pageContext.request.contextPath}/sign/signUpForm" >회원가입<p>
	<div class="member_login">아이디/비밀번호를 잊어버리셨습니까?</div><a href="${pageContext.request.contextPath}/sign/findId " >아이디 / 비밀번호 찾기</a><p class="small">
	</div>
</body>
</html>



