<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>자주 묻는 질문 업데이트 폼</h1>
<br>
<form action="${pageContext.request.contextPath}/admin/updateFAQ"
	method="get">
	<input type="text" value="${faqDTO.FAQNo}" name="FAQNo" hidden="hidden" />
	<table class="boardTable">
		<tr>
			<th>질문</th>
			<th><input type="text" value="${faqDTO.FAQSub}"
				required="required" name="FAQSub" /></th>
		</tr>
		<tr>
			<th>답변</th>
			<th><input type="text" value="${faqDTO.FAQContent}"
				required="required" name="FAQContent" /></th>
		</tr>
	</table>
	<button>수정</button>
</form>