<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

공지사항 디테일 페이지
<table class="boardTable">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성날짜</th>
		<th>작성내용</th>
		<th>조회수</th>
		<th>이미지</th>
	</tr>
	<tr>
		<th>${noticeDTO.noticeNo}</th>
		<th>${noticeDTO.noticeSub}</th>
		<th>${noticeDTO.noticeDt}</th>
		<th>${noticeDTO.noticeContent}</th>
		<th>${noticeDTO.noticeHit}</th>
		<th><img
			src="${pageContext.request.contextPath}/resources/images/notice/${noticeDTO.noticeImage}" />
			${noticeDTO.noticeImage}</th>
	</tr>
	<tr>
		<th><a
			href="${pageContext.request.contextPath}/admin/updateNotice/${noticeDTO.noticeNo}">수정</a></th>
		<th><a
			href="${pageContext.request.contextPath}/admin/deleteNotice/${noticeDTO.noticeNo}">삭제</a></th>
	<tr>
</table>