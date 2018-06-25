<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
	<h1>공지사항 쓰기</h1>
	<br>
	<form
		action="${pageContext.request.contextPath}/admin/insertNotice?${_csrf.parameterName}=${_csrf.token}"
		method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 90%">
			<tr>
				<th>제목</th>
				<th><input type="text" name="noticeSub" required="required" /></th>
			</tr>
			<tr>
				<th>내용</th>
				<th><input type="text" name="noticeContent" required="required" /></th>
			</tr>
			<tr>
				<th>이미지</th>
				<th><input type="file" name="noticeImageFile" /></th>
			</tr>
		</table>
		<button>글쓰기</button>
	</form>
</div>