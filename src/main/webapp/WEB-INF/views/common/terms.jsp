<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>이용약관</h1>
<br>
<table class="boardTable">
	<c:forEach items="${list}" var="termsDTO">
		<tr>
			<th class="thead">제목</th>
			<th class="tbody">${termsDTO.termsSub}</th>
		</tr>
		<tr>
			<th class="thead">내용</th>
			<th class="tbody">${termsDTO.termsContent}</th>
		</tr>
		<tr>
			<th><a
				href="${pageContext.request.contextPath}/admin/updateTerms/${termsDTO.termsNo}">수정</a></th>
			<th><a
				href="${pageContext.request.contextPath}/admin/deleteTerms/${termsDTO.termsNo}">삭제</a></th>
		<tr>
	</c:forEach>
</table>

<h4>
	<a href="${pageContext.request.contextPath}/admin/insertTermsForm">
		이용약관 쓰기 </a>
</h4>