<%@page import="kosta.mvc.model.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
	<h1>공지사항</h1>
	<br>
	<table class="table table-bordered" style="width: 90%">
		<tr>
			<th>글번호</th>
			<th>${noticeDTO.noticeNo}</th>
		</tr>
		<tr>
			<!-- <th>번호</th> -->
			<th>제목</th>
			<th>${noticeDTO.noticeSub}</th>
		</tr>

		<tr>
			<th colspan="2"><c:set var="noticeImage"
					value="${noticeDTO.noticeImage}"></c:set> <c:choose>
					<c:when test="${!empty noticeImage}">
						<img
							src="${pageContext.request.contextPath}/resources/images/notice/${noticeDTO.noticeImage}"
							width="300px" height="auto" />
					</c:when>
				</c:choose> ${noticeDTO.noticeContent}</th>
		</tr>

		<tr>
			<th>작성날짜</th>
			<th>${noticeDTO.noticeDt}</th>
		</tr>
		<tr>
			<th>조회수</th>
			<th>${noticeDTO.noticeHit}</th>
		</tr>

	</table>
	<a
		href="${pageContext.request.contextPath}/admin/updateNotice/${noticeDTO.noticeNo}"><button
			type="button" class="btn btn-primary">수정</button></a> <a
		href="${pageContext.request.contextPath}/admin/deleteNotice/${noticeDTO.noticeNo}"><button
			type="button" class="btn btn-danger">삭제</button></a>
</div>