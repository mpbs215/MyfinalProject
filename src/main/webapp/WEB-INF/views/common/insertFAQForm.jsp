<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>자주 묻는 질문</h1>
<br>
<form action="${pageContext.request.contextPath}/admin/insertFAQ"
	method="get">
	<table class="table table-bordered" style="width: 90%">
		<tr>
			<th class="termsHead" style="width: 20%">질문</th>
			<th><input type="text" required="required" name="FAQSub" /></th>
		</tr>
		<tr>
			<th class="termsHead" style="width: 20%">답변</th>
			<th><input type="text" required="required" name="FAQContent"
				class="tcontent" /></th>
		</tr>
	</table>
	<button class="btn btn-primary">글쓰기</button>
</form>