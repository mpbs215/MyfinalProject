<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="mvo" property="principal" />

<h1>공지사항</h1>
<br>
<table class="table table-bordered" style="width: 90%">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<!-- <th>작성내용</th> -->
		<th>조회수</th>
		<th>작성날짜</th>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th>수정</th>
			<th>삭제</th>
		</sec:authorize>
	</tr>
	<c:forEach items="${list}" var="noticeDTO">
		<tr>
			<th>${noticeDTO.noticeNo}</th>
			<th><a
				href="${pageContext.request.contextPath}/common/noticeDetail/${noticeDTO.noticeNo}"
				style="color: black;">${noticeDTO.noticeSub}</a></th>
			<%-- <th>${noticeDTO.noticeContent}</th> --%>
			<th>${noticeDTO.noticeHit}</th>
			<th>${noticeDTO.noticeDt}</th>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<th><a
					href="${pageContext.request.contextPath}/admin/updateNotice/${noticeDTO.noticeNo}"
					class="btn btn-primary">수정</a></th>
				<th><a
					href="${pageContext.request.contextPath}/admin/deleteNotice/${noticeDTO.noticeNo}"
					class="btn btn-danger">삭제</a></th>
			</sec:authorize>
		</tr>
	</c:forEach>
</table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<h4>
		<a href="${pageContext.request.contextPath}/admin/insertNoticeForm"
			class="btn btn-primary"> 공지사항 쓰기 </a>
	</h4>
</sec:authorize>