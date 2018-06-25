<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
	<h1>이용약관 수정</h1>
	<br>
	<form action="${pageContext.request.contextPath}/admin/updateTerms"
		method="get">
		<input type="text" value="${termsDTO.termsNo}" name="termsNo"
			hidden="hidden" />
		<table class="table table-bordered" style="width: 90%">
			<tr>
				<th>이용약관 제목</th>
				<th><input type="text" value="${termsDTO.termsSub}"
					required="required" name="termsSub" class="inputTextSub" /></th>
			</tr>
			<tr>
				<th>이용약관 내용</th>
				<th><textarea required="required" name="termsContent"
						class="inputTextContent" rows="7">${termsDTO.termsContent}</textarea></th>
			</tr>
		</table>
		<button class="btn btn-primary">수정</button>
	</form>
</div>