<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>이용약관</h1>
<br>
<c:forEach items="list" var="termsDTO">
${termsDTO.termsNo} <br>
${termsDTO.termsSubject} <br>
${termsDTO.termsContent} <br>
</c:forEach>
