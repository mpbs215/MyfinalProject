<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>TermsUpdateForm입니다.</h1>
<br>
<form action="${pageContext.request.contextPath}/admin/updateTerms"
	method="get">
	<input type="text" value="${termsDTO.termsNo}" name="termsNo" hidden="hidden" />
	<table class="boardTable">
		<tr>
			<th>이용약관 제목</th>
			<th><input type="text" value="${termsDTO.termsSub}"
				required="required" name="termsSub" /></th>
		</tr>
		<tr>
			<th>이용약관 내용</th>
			<th><input type="text" value="${termsDTO.termsContent}"
				required="required" name="termsContent"/></th>
		</tr>
	</table>
	<button>수정</button>
</form>