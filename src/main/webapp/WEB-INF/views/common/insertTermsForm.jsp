<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>이용약관 작성</h1>

<br>
<form action="${pageContext.request.contextPath}/admin/insertTerms"
	method="get">
	<table class="table table-bordered" style="width: 90%">
		<tr style="width: 100%">
			<th>이용약관 제목</th>
			<th><input type="text" required="required" name="termsSub" /></th>
		</tr>
		<tr>
			<th>이용약관 내용</th>
					<th><textarea required="required" name="termsContent"
					class="inputTextContent" rows="7">${termsDTO.termsContent}</textarea></th>
		</tr>
	</table>
	<button class="btn btn-primary">글쓰기</button>
</form>