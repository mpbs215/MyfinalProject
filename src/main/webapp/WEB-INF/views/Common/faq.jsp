<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>자주 묻는 질문</h1>
<br>
<table class="boardTable">
	<c:forEach items="${list}" var="faqDTO">
		<tr>
			<th class="thead">질문</th>
			<th class="tbody">${faqDTO.FAQSub}</th>
		</tr>
		<tr>
			<th class="thead">답변</th>
			<th class="tbody">${faqDTO.FAQContent}</th>
		</tr>
		<tr>
			<th><a
				href="${pageContext.request.contextPath}/admin/updateFAQ/${faqDTO.FAQNo}">수정</a></th>
			<th><a
				href="${pageContext.request.contextPath}/admin/deleteFAQ/${faqDTO.FAQNo}">삭제</a></th>
		<tr>
	</c:forEach>
</table>

<h4>
	<a href="${pageContext.request.contextPath}/admin/insertFAQForm">
		자주 묻는 질문 쓰기 </a>
</h4>