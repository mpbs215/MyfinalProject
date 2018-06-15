<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

insert form

<form action="${pageContext.request.contextPath}/admin/insertTerms"
	method="get">
	<table class="boardTable">
		<tr>
			<th class="thead">이용약관 제목</th>
			<th class="tbody"><input type="text" required="required"
				name="termsSub" /></th>
		</tr>
		<tr>
			<th class="thead">이용약관 내용</th>
			<th class="tbody"><input type="text" required="required"
				name="termsContent" class="tcontent"/></th>
		</tr>
	</table>
	<button>글쓰기</button>
</form>