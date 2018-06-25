<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="mvo" property="principal" />

<div class="container" style="background-color: white; padding: 20px;">
<h1>FAQ</h1>
<br>
<c:forEach items="${list}" var="faqDTO">
	<table class="table table-bordered" style="width: 90%">
		<tr>
			<th class="termsHead" style="width: 20%">질문</th>
			<th>${faqDTO.FAQSub}</th>
		</tr>
		<tr>
			<th class="termsHead" style="width: 20%">답변</th>
			<th>${faqDTO.FAQContent}</th>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/admin/updateFAQ/${faqDTO.FAQNo}" class="btn btn-primary">수정</a></th>
				<th><a
					href="${pageContext.request.contextPath}/admin/deleteFAQ/${faqDTO.FAQNo}" class="btn btn-danger">삭제</a></th>
			</tr>
		</sec:authorize>
	</table>
</c:forEach>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<h4>
		<a href="${pageContext.request.contextPath}/admin/insertFAQForm" class="btn btn-primary">
			자주 묻는 질문 쓰기 </a>
	</h4>
</sec:authorize>
</div>