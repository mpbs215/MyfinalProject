<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
<h2>회원 목록</h2>
	<table class="table table-bordered" style="width: 100%">
		<tr class="termsHead" style="width: 100%">
			<th style="width: 10%;">판매자 아이디</th>
			<th style="width: 10%;">주차장 제목</th>
			<th>주소</th>
			<th>주차가능 대수</th>
			<th>주차장 설명</th>
			<th>가격</th>
			<th style="width: 10%;">삭제</th>
		</tr>
		<c:forEach items="${list}" var="parkDTO">
			<tr>
				<td style="width: 10%;">${parkDTO.userId}</td>
				<td style="width: 10%;">${parkDTO.parkName}</td>
				<td>${parkDTO.parkAddr}</td>
				<td>${parkDTO.parkSize}</td>
				<td>${parkDTO.parkContent}</td>
				<td>${parkDTO.price}</td>
				<td style="width: 10%;"><a
					href="${pageContext.request.contextPath}/admin/manageParkDelete/${parkDTO.parkNo}"
					class="btn btn-primary" id="btnDelete">삭제</a>
			</tr>
		</c:forEach>
	</table>

</div>