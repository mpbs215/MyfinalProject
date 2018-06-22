<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="mvo" property="principal" />


<h1>이용약관</h1>

<br>
<c:forEach items="${list}" var="termsDTO">

	<table class="table table-bordered" style="width: 90%">
		<tr class="termsHead" style="width: 100%">
			<th>제목</th>
			<th>내용</th>
		</tr>
		<tr>
			<th>${termsDTO.termsSub}</th>
			<th>${termsDTO.termsContent}</th>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/admin/updateTerms/${termsDTO.termsNo}"
					class="btn btn-primary">수정</a></th>
				<th><a
					href="${pageContext.request.contextPath}/admin/deleteTerms/${termsDTO.termsNo}"
					class="btn btn-danger">삭제</a></th>
			</tr>
		</sec:authorize>
	</table>
</c:forEach>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<h4>

		<a href="${pageContext.request.contextPath}/admin/insertTermsForm">
			<button type="button" class="btn btn-primary">이용약관 쓰기</button>
		</a>
	</h4>
</sec:authorize>
