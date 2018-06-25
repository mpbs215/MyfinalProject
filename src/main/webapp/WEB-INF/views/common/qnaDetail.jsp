<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="mvo" property="principal" />

<script>
	$(document)
			.ready(
					function() {
						$("#qnaReviewUpdateBtn")
								.click(
										function() {
											$
													.ajax({
														url : "${pageContext.request.contextPath}/admin/updateQNAReview/"
																+ $(
																		'#QNAReview')
																		.val()
																+ "/"
																+ $('#QNANo')
																		.val(),
														type : "get", //method방식(get or post)
														dataType : "text", //요청결과데이터타입(text, html, xml, json)
														/* data : , *///서버에게 보낼 parameter정보
														success : function(
																result) {
															alert("성공");
															$("#Review").text(
																	result);

														},
														error : function(
																request,
																status, error) {
															alert("code:"
																	+ request.status
																	+ "\n"
																	+ "message:"
																	+ request.responseText
																	+ "\n"
																	+ "error:"
																	+ error);
														}
													})
										})
					});
</script>

<h1>QNA Detail</h1>
<input type="hidden" value="${qnaDTO.QNANo}" id="QNANo">
<table class="table table-bordered" style="width: 90%">
	<tr>
		<!-- <th>질문번호</th> -->
		<th>작성자</th>
		<th>${qnaDTO.userId}</th>
	</tr>
	<tr>
		<th>질문제목</th>
		<th>${qnaDTO.QNASub}</th>
	</tr>
	<tr>
		<th>질문내용</th>
		<th>${qnaDTO.QNAContent}</th>
	</tr>
	<tr>
		<c:set var="QNAImage" value="${qnaDTO.QNAImage}"></c:set>
		<c:if test="${!empty QNAImage}">
			<th>이미지</th>
		</c:if>
		<c:if test="${!empty QNAImage}">
			<th><img
				src="${pageContext.request.contextPath}/resources/images/QNA/${qnaDTO.QNAImage}"
				width="300px" height="auto" /></th>
		</c:if>
	</tr>
	<tr>
		<th>작성날짜</th>
		<th>${qnaDTO.QNADT}</th>

	</tr>
	<tr>
		<th>조회수</th>
		<th>${qnaDTO.QNAHit}</th>
	</tr>
	<sec:authorize access="isAuthenticated()">
		<c:set var="userId" value="${mvo.userId}"></c:set>
		<c:set var="qnaId" value="${qnaDTO.userId}"></c:set>
		<c:if test="${userId eq qnaId}">
			<tr>
				<th colspan="2"><a
					href="${pageContext.request.contextPath}/common/updateQNA/${qnaDTO.QNANo}"
					class="btn btn-primary">수정</a> <a
					href="${pageContext.request.contextPath}/common/deleteQNA/${qnaDTO.QNANo}"
					class="btn btn-danger">삭제</a></th>
			</tr>
		</c:if>
	</sec:authorize>
</table>
<c:set var="Review" value="${qnaDTO.QNAReview}"></c:set>

<table class="table table-bordered" style="width: 90%">
	<tr>
		<th>답변</th>
	</tr>
	<c:choose>
		<c:when test="${!empty Review}">
			<tr>
				<th><div id="Review">${qnaDTO.QNAReview}</div></th>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<th><div id="Review">답변 없음</div></th>
			</tr>
		</c:otherwise>
	</c:choose>
</table>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<table class="table table-bordered" style="width: 90%">
		<tr>
			<th>답변</th>
			<th>답변 작성하기</th>
		</tr>
		<tr>
			<th><input type="text" name="QNAReview" id="QNAReview"></th>
			<c:choose>
				<c:when test="${empty Review}">
					<th><button type="button" class="btn btn-primary"
							id="qnaReviewUpdateBtn" class="btn btn-primary">리뷰 작성</button></th>
				</c:when>
				<c:otherwise>
					<th><button type="button" name="QNAReview"
							id="qnaReviewUpdateBtn" class="btn btn-primary">리뷰 수정</button></th>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</sec:authorize>