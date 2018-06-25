<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="mvo" property="principal" />

<div class="container" style="background-color: white; padding: 20px;">

<h1>QNA</h1>

<sec:authorize access="isAuthenticated()">
	<h4 style="text-align: right; padding-right: 150px;">
		<a href="${pageContext.request.contextPath}/common/insertQNAForm"
			class="btn btn-primary"> QNA 쓰기 </a>
	</h4>
</sec:authorize>
<table class="table table-bordered" style="width: 90%">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>작성날짜</th>
		<th>조회수</th>
		<th>답변여부</th>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th>수정</th>
			<th>삭제</th>
		</sec:authorize>
	</tr>
	<c:forEach items="${QNAList}" var="qnaDTO">
		<tr>
			<th>${qnaDTO.QNANo}</th>
			<th><a
				href="${pageContext.request.contextPath}/common/qnaDetail/${qnaDTO.QNANo}"
				style="color: black;">${qnaDTO.QNASub}</a></th>
			<th>${qnaDTO.userId}</th>
			<th>${qnaDTO.QNADT}</th>
			<th>${qnaDTO.QNAHit}</th>
			<th><c:set var="ReviewIsEmpty" value="${qnaDTO.QNAReview}" /> <c:choose>
					<c:when test="${empty ReviewIsEmpty}">답변예정</c:when>
					<c:otherwise> 답변완료 </c:otherwise>
				</c:choose></th>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th><a
					href="${pageContext.request.contextPath}/common/updateQNA/${qnaDTO.QNANo}">수정</a></th>
				<th><a
					href="${pageContext.request.contextPath}/common/deleteQNA/${qnaDTO.QNANo}">삭제</a></th>
			</sec:authorize>
		</tr>
	</c:forEach>
</table>

<div id="pageBar">${pageBar}</div>
</div>