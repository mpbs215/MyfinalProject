<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
	<h2>회원 목록</h2>
	<table class="table table-bordered" style="width: 100%">
		<tr class="termsHead" style="width: 100%">
			<th style="width: 10%;">아이디</th>
			<th style="width: 10%;">이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>회원가입일자</th>
			<th style="width: 10%;">삭제</th>
		</tr>
		<c:forEach items="${list}" var="userDTO">
			<tr>
				<td style="width: 10%;">${userDTO.userId}</td>
				<td style="width: 10%;">${userDTO.userName}</td>
				<td>${userDTO.email}</td>
				<td>${userDTO.hp}</td>
				<td>${userDTO.address}</td>
				<td>${userDTO.regidate}</td>
				<td style="width: 10%;"><a
					href="${pageContext.request.contextPath}/admin/manageUserDelete/${userDTO.userId}"
					class="btn btn-primary" id="btnDelete">삭제</a>
			</tr>
		</c:forEach>
	</table>
</div>