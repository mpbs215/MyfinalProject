<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>QNA Detail</h1>

<table>
	<tr>
		<th>질문번호</th>
		<th>작성자</th>
		<th>질문제목</th>
		<th>질문내용</th>
		<th>작성날짜</th>
		<th>답변</th>
		<th>답변일</th>
		<th>조회수</th>
		<th>이미지</th>
	</tr>

	<tr>
		<th>${qnaDTO.QNANo}</th>
		<th>${qnaDTO.userId}</th>
		<th>${qnaDTO.QNASub}</th>
		<th>${qnaDTO.QNAContent}</th>
		<th>${qnaDTO.QNADT}</th>
		<th>${qnaDTO.QNAReview}</th>
		<th>${qnaDTO.QNAReviewDT}</th>
		<th>${qnaDTO.QNAHit}</th>
		<th>${qnaDTO.QNAImage}</th>
	</tr>

</table>