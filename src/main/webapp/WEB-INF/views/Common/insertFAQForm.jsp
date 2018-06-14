<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>자주 묻는 질문</h1>

<form action="${pageContext.request.contextPath}/admin/insertFAQ"
	method="get">
	<table class="boardTable">
		<tr>
			<th class="thead">질문</th>
			<th class="tbody"><input type="text" required="required"
				name="FAQSub" /></th>
		</tr>
		<tr>
			<th class="thead">답변</th>
			<th class="tbody"><input type="text" required="required"
				name="FAQContent" class="tcontent"/></th>
		</tr>
	</table>
	<button>글쓰기</button>
</form>