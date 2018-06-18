<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
</head>
<body>
<h2>로그인</h2>

<!--
	c:if
	authentication-failure-url 이동시 사용 코드
	if test="{param.fail='fail'}"
	로그인 실패했습니다. ID 와 PASS를 확인하세요.
	c:if
-->

<c:if test="${not empty requestScope.errorMessage}">
	<span style="color:red">${requestScope.errorMessage}</span>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<table style="width:350px">
					<tr>
						<td width="70px">ID</td>
						<td><input type="text" name="userId" size="30"></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="password" name="password" size="31"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="로그인"></td>
					</tr>
				</table>
	</form>
	회원이 아니십니까?? <a href=" ${pageContext.request.contextPath}/sign/signUpForm" >회원가입</a><p>
	아이디를 잊어버리셨습니까?<a href="${pageContext.request.contextPath}/sign/findId " >아이디찾기</a><p>
	비밀번호를 잊어버리셨습니까?<a href="${pageContext.request.contextPath}/sign/findPassword " >비밀번호 찾기</a><p>
</body>
</html>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



로그인 페이지입니다.
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject
