<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<scriptQ
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

	<div class="container">

		<h2>Inline form</h2>

		<form>
			
				<div class="form-group col-md-4">
					<label for="userId">아이디</label> 
					<input type="text" class="form-control" id="userId" placeholder="Enter Id" name="userId" readonly="readonly">
				</div>
				<div class="form-group col-md-6">
					<label for="pwd">비밀번호</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="pwd">
				</div>
			
			<div class="form-group col-md-4">
				<label for="userName">이름</label> <input type="text"
					class="form-control" id="userName" placeholder="Enter Name"
					name="userName">
			</div>
			<div class="form-group col-md-8">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group col-md-8">
				<label for="hp">전화번호</label> <input type="text" class="form-control"
					id="hp" placeholder="Enter Phone Number" name="hp">
			</div>
			<div class="form-group col-md-9">
				<label for="address">주소</label> <input type="text"
					class="form-control" id="adderess" placeholder="Enter address"
					name="address">
			</div>
			<label for="regiDate ">회원가입날짜</label> <input type="text"
				class="form-control col-md-4" id="regiDate" placeholder="regiDate"
				name="regiDate" readonly="readonly">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
<%@ include file="../tiles/footer.jsp"%>
</html>