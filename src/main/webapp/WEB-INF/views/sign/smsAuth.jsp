<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<script>
			$(document).ready(function() {
				$("#childForm").submit(function() {
					window.close();
				})
			})
	</script>
	
			<form id="childForm">
				<input type="text" name="phoneNum" id="phoneNum" placeholder="번호를 입력해주세요">
				<input type="button" value="창닫기" onclick="window.close()" >
				<input type="submit" value="입력하기" id="phoneForm">
			</form>
			
</body>
</html>