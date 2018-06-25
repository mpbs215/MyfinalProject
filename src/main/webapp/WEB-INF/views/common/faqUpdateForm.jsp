<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container" style="background-color: white; padding: 20px;">
	<h1>FAQ</h1>
	<br>
	<form action="${pageContext.request.contextPath}/admin/updateFAQ"
		method="get">
		<input type="text" value="${faqDTO.FAQNo}" name="FAQNo"
			hidden="hidden" />
		<table class="table table-bordered" style="width: 90%">
			<tr>
				<th class="termsHead" style="width: 20%">질문</th>
				<th><input type="text" value="${faqDTO.FAQSub}"
					required="required" name="FAQSub" /></th>
			</tr>
			<tr>
				<th class="termsHead" style="width: 20%">답변</th>
				<th><input type="text" value="${faqDTO.FAQContent}"
					required="required" name="FAQContent" /></th>
			</tr>
		</table>
		<button class="btn btn-primary">수정</button>
	</form>
</div>