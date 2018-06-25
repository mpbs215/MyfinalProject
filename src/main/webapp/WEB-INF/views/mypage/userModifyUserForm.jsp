<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<link href="${pageContext.request.contextPath}/resources/css/mypage.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

function getPassword() {
	location.href="${pageContext.request.contextPath}/user/getPassword?userId="+$("#userId").val().trim();
}

	$(document).ready(function() {
		$("#leaveMemberBtn").on("click", function() {
			
			var unSign = confirm("정말 탈퇴 하시겠습니까?");
			
			if (unSign) {
				location.href="${pageContext.request.contextPath}/user/unSign?password="+$("#pwd").val().trim() +"&userId="+$("#userId").val();
			} else {
				alert("취소 하셨습니다.");
			}
		})
	})

</script>
<div class="mypage">
	<div class="mypage-inner">
	<h2>회원정보수정</h2>
	<form action="${pageContext.request.contextPath}/user/userModifyUser">
		<div class="mypage-list">
			<label for="userId">아이디</label> 
			<input type="text" class="form-control" name="userId" readonly="readonly"  id="userId" value="${dto.userId}">
		</div>
		<div class="mypage-list">
			<label for="pwd">비밀번호</label> 
			<input type="password" class="form-control" id="pwd" name="password">
		</div>
		<div class="mypage-list">
			<label for="userName">이름</label> 
			<input type="text" class="form-control" name="userName" value="${dto.userName}">
		</div>
		<div class="mypage-list">
			<label for="email">Email</label> 
			<input type="email" class="form-control" name="email" value="${dto.email}">
		</div>
		<div class="mypage-list">
			<label for="hp">전화번호</label> 
			<input type="text" class="form-control" name="hp"  id="hp" value="${dto.hp}">
		</div>
		<div class="mypage-list">
			<label for="address">주소</label> 
			<input type="text" class="form-control" name="address" value="${dto.address}">
		</div>
		<br />
		<div class="mypage-list-btn">
			<input type="submit" value="수정하기" id="list-btn"/>
			<input type="button" value="회원탈퇴하기" id="leaveMemberBtn"/>
		</div>
		</form>
	</div>
</div>