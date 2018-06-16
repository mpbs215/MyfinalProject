<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>QNA 수정 폼</h1>

<form action="${pageContext.request.contextPath}/common/updateQNA?${_csrf.parameterName}=${_csrf.token}"
	method="post">
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
			<th>파일명</th>
		</tr>

		<tr>
			<th>${qnaDTO.QNANo}</th>
			<th>${qnaDTO.userId}</th>
			<th><input type="text" value="${qnaDTO.QNASub}" name="QNASub"></th>
			<th><input type="text" ${qnaDTO.QNAContent} name="QNAContent"></th>
			<th>${qnaDTO.QNADT}</th>
			<th>${qnaDTO.QNAReview}</th>
			<th>${qnaDTO.QNAReviewDT}</th>
			<th>${qnaDTO.QNAHit}</th>
			<th>${qnaDTO.QNAImage}</th>
		</tr>

	</table>
	<input type="file" name="QNAImageFile" value="파일 업로드" />
	<button>수정</button>
</form>