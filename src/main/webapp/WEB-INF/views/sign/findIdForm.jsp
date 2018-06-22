<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
<form:form id="findId" class="form-horizontal" role="form" commandName="userDTO" action="${pageContext.request.contextPath}/sign/idFind" method="post">
                                <div class="form-group">
                                    <label for="email" class="col-md-2 control-label">이메일</label>
                                    <div class="col-md-10">
                                        <input type="text" class="form-control" name="email"  id="email"  value="${userDTO.email}" placeholder="이메일을 작성해주세요">
                                    </div>
                                        <div class="col-md-offset-2 col-md-10">
                                            <div style="color:red ; margin-top:2px" >
                                                <form:errors path="email"/>
                                                 <form:errors/>
                                            </div>
                                        </div>                 
                                </div>
                                <div class="form-group" style="margin-left:82%">
                                    <!-- Button -->
                                                  
                                    <div class="col-md-offset-10 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-warning">확인</button>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                                가입하신 이메일로 아이디와 비밀번호를 전송해드리겠습니다.
                                        </div>
                                    </div>
                                </div>    
 	</form:form>
</body>
=======
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<form:form id="findId" class="form-horizontal" role="form"
		commandName="userDTO"
		action="${pageContext.request.contextPath}/common/idFind"
		method="post">
		<div class="form-group">
			<label for="email" class="col-md-2 control-label">이메일</label>
			<div class="col-md-10">
				<input type="text" class="form-control" name="email" id="email"
					value="${userDTO.email}" placeholder="이메일을 작성해주세요">
			</div>
			<div class="col-md-offset-2 col-md-10">
				<div style="color: red; margin-top: 2px">
					<form:errors path="email" />
					<form:errors />
				</div>
			</div>
		</div>
		<div class="form-group" style="margin-left: 82%">
			<!-- Button -->

			<div class="col-md-offset-10 col-md-9">
				<button id="btn-signup" type="submit" class="btn btn-warning">확인</button>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12 control">
				<div
					style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
					가입하신 이메일로 아이디와 비밀번호를 전송해드리겠습니다.</div>
			</div>
		</div>
	</form:form>
</body>
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject
