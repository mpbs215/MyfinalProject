<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>공지사항 페이지</h1>

<table class="boardTable">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성날짜</th>
		<th>작성내용</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list}" var="noticeDTO">
		<tr>
			<th>${noticeDTO.noticeNo}</th>
			<th><a
				href="${pageContext.request.contextPath}/common/noticeDetail/${noticeDTO.noticeNo}">${noticeDTO.noticeSub}</a></th>
			<th>${noticeDTO.noticeDt}</th>
			<th>${noticeDTO.noticeContent}</th>
			<th>${noticeDTO.noticeHit}</th>
		</tr>
		<tr>
			<th><a
				href="${pageContext.request.contextPath}/admin/updateNotice/${noticeDTO.noticeNo}">수정</a></th>
			<th><a
				href="${pageContext.request.contextPath}/admin/deleteNotice/${noticeDTO.noticeNo}">삭제</a></th>
		<tr>
	</c:forEach>
</table>
<h4>
	<a href="${pageContext.request.contextPath}/admin/insertNoticeForm">
		공지사항 쓰기 </a>
</h4>