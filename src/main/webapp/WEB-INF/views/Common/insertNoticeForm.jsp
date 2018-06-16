<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

insert form

<form
	action="${pageContext.request.contextPath}/admin/insertNotice?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<table class="boardTable">
		<tr>
			<th>제목</th>
			<th>작성내용</th>
			<th>이미지</th>
		</tr>
		<tr>
			<th><input type="text" name="noticeSub" required="required" /></th>
			<th><input type="text" name="noticeContent" required="required" /></th>
			<th><input type="file" name="noticeImageFile" /></th>
		</tr>
	</table>
	<button>글쓰기</button>
</form>