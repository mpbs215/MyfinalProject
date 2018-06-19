<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="../tiles/header.jsp" %>
</head>
<body>
 <h2>회원 목록</h2>
    <table border="1" width="700px">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>회원가입일자</th>
            <th> 삭제 </th>
        </tr>
        <c:forEach var="row" items="${list}">
        <tr>
            <td>${row.userId}</td>
            <td>${row.userName}</td>
            <td>${row.email}</td>
            <td>${row.hp}</td>
            <td>${row.address}</td>
            <td>${row.regidate}</td>
            <td><input type="button" value="삭제" id="btnDelete">
        </tr>
        </c:forEach>
    </table>
</body>
<%@include file="../tiles/footer.jsp" %>
</html>