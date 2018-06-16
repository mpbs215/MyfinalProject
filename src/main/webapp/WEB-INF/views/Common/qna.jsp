<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>QNA</h1>

<table>
	<tr>
		<th>글번호</th>
		<th>글쓴이</th>
		<th>제목</th>
		<th>작성날짜</th>
		<th>조회수</th>
		<th>답변여부</th>
	</tr>
	<c:forEach items="${QNAList}" var="qnaDTO">
		<tr>
			<th>${qnaDTO.QNANo}</th>
			<th><a
				href="${pageContext.request.contextPath}/common/qnaDetail/${qnaDTO.QNANo}">${qnaDTO.userId}</a></th>
			<th>${qnaDTO.QNASub}</th>
			<th>${qnaDTO.QNADT}</th>
			<th>${qnaDTO.QNAHit}</th>
			<th><c:set var="ReviewIsEmpty" value="${qnaDTO.QNAReview}" /> <c:choose>
					<c:when test="${empty ReviewIsEmpty}">답변예정</c:when>
					<c:otherwise> 답변완료 </c:otherwise>
				</c:choose></th>
		</tr>
		<tr>
			<th><a
				href="${pageContext.request.contextPath}/common/updateQNA/${qnaDTO.QNANo}">수정</a></th>
			<th><a
				href="${pageContext.request.contextPath}/common/deleteQNA/${qnaDTO.QNANo}">삭제</a></th>
		</tr>
	</c:forEach>
</table>
<h4>
	<a href="${pageContext.request.contextPath}/common/insertQNAForm">
		QNA 쓰기 </a>
</h4>