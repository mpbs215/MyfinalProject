<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	var checkResultId="";		
	$("#signUpForm").submit(function(){			
		if($("#signUpForm :input[name=userId]").val().trim()==""){
			alert("아이디를 입력하시지 않았습니다. 아이디를 입력해주세요");				
			return false;
		}
		if($("#signUpForm :input[name=password]").val().trim()==""){
			alert("패스워드를 입력하세요");				
			return false;
		}
		if($("#signUpForm :input[name=userName]").val().trim()==""){
			alert("이름을 입력하세요");				
			return false;
		}
		
		if($("#signUpForm :input[name=email]").val().trim()==""){
			alert("이메일 주소를 입력하세요");				
			return false;
		}	
		
		if($("#signUpForm :input[name=hp]").val().trim()==""){
			alert("핸드폰 번호를 입력하세요");				
			return false;
		}	
		
		if($("#signUpForm :input[name=address]").val().trim()==""){
			alert("주소를 입력하세요");				
			return false;
		}	
		
		if(checkResultId==""){
			alert("아이디 중복확인을 하세요");
			return false;
		}		
	});//submit
	
	$("#signUpForm :input[name=userId]").keyup(function(){
		var id=$(this).val().trim();
		if(id.length <  4 || id.length > 10){
			$("#idCheckView").html("입력 가능한 아이디의 범위는 4~10 글자 입니다.").css("background","pink");
			checkResultId="";
		} else {
			
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/sign/idCheck",				
			data:"${_csrf.parameterName}=${_csrf.token}&userId="+id,	
			dataType : "text",
			success:function(message){		
				console.log(message);
				if(message == "fail"){
				$("#idCheckView").html("  "+id+" ID Can't Use!! ").css("background","green");
					checkResultId="";
				}else{						
					$("#idCheckView").text("  "+id+" ID Can Use!! ").css("background","yellow");		
					checkResultId=userId;
					}					
				}//callback			
			});//ajax
		}
	});//keyup
});//ready
</script>
</head>

<body>
<h2>User SignUp Form</h2><p>
<form method="post" action="${pageContext.request.contextPath}/sign/signUp" id="signUpForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
ID <input type="text" name="userId" id="userId"><span id="idCheckView">아이디 중복 확인</span><br><br>
PASSWORD <input type="password" name="password"><br><br>
NAME <input type="text" name="userName"><br><br>
E-Mail<input type="text" name="email"><br><br>
HP : <input type="text" name="hp"><br><br>
ADDRESS : <input type="text" name="address"><br><br>
 <input type="hidden" name="regidate"><br>
SELLER <input type="radio" value="0" name="seller">ROLE_MEMBER
		  <input type="radio" value="1" name="seller">ROLE_ADMIN<br><br>
<input type="submit" value="회원가입하기">
</form>
</body>
</html>


회원가입페이지입니다.
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject
