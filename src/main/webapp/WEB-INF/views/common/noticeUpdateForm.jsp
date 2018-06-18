<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>공지사항 업데이트 폼</h1>
<br>
<form
	action="${pageContext.request.contextPath}/admin/updateNotice?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="text" value="${noticeDTO.noticeNo}" name="noticeNo"
		hidden="hidden" />
	<table class="boardTable">
		<tr>
			<th>공지사항 제목</th>
			<th><input type="text" value="${noticeDTO.noticeSub}"
				required="required" name="noticeSub" /></th>
		</tr>
		<tr>
			<th>공지사항 내용</th>
			<th><input type="text" value="${noticeDTO.noticeContent}"
				required="required" name="noticeContent" /></th>
		</tr>
		<tr>
			<th>파일 선택</th>
			<th><input type="file" name="noticeImageFile" /></th>
		</tr>
	</table>
	<button>수정</button>
</form>