<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


<script type="text/javascript">

$(function(){	
	// 삭제 버튼(하나 삭제)
	$('button[name="deleteOne"]').click(function(){		
		//console.log($(this).val());
		 	
		$.ajax({
			url:"${pageContext.request.contextPath}/seller/sellerParkDelete",
			dataType:"text",
			data:"pNo="+$(this).val(),
			success:function(result){
				if(result > 0){					
					alert("삭제되었습니다.");
					window.location.reload();
				}else{
					alert("삭제 실패");
				}
			},
			error:function(error){
				console.log("에러발생" + error);
			}			
		})   
	})
	
	// 전체 체크하기
	$("#selectAll").click(function(){
		 var chk = $(this).is(":checked");//.attr('checked');
	     if(chk) $(".select_subject input").prop('checked', true);
	     else  $(".select_subject input").prop('checked', false);
	})
			
	// 삭제 (체크된 주차장 모두 삭제)
	$("#delete").click(function(){
		
		var parkIdArr = [];	
		// 체크된 주차장들의 parkNo 추출해 배열에 넣고 보내기
		$("input[name=selectPark]:checked").each(function(){
			alert($(this).val());
			var parkNo = $(this).val();
			parkIdArr.push(parkNo);
		})
	})
	
	// 주차장 등록 페이지 연결
	
	// 수정 페이지 연결

})
</script>
</head>
<body>

주차장 리스트 - 수정 필요.


<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-sm-11">

				<div class="panel-header">
					<div class="row text-center">
						<div class="col-xs-3">
						<div class="col-xs-2">	
						<input type="checkbox" name="selectAll" id="selectAll"/>
						</div>
						<div class="col-xs-10">
						<button type="button" class="btn btn-default" id="delete">
								선택한 주차장 삭제
						</button>
						</div>					
						</div>
						<div class="col-xs-7"></div>
						<div class="col-xs-2">
							<button type="button" class="btn btn-success btn-block">주차장 등록</button>
						</div>
					</div>
				</div>

				<hr/>

				<div class="panel-body">
					<ul class="select_subject">
					<c:choose>

						<c:when test="${empty requestScope.sellerParkList}">
							<p align="center">
								<b><span style="font-size: 9pt;">주차장 등록 내역이 없습니다.</span></b>
							</p>
						</c:when>

						<c:otherwise>
							<c:forEach items="${requestScope.sellerParkList}" var="parkDto">
								
								<!-- 주차장 이름, 주소, 등록시작일, 등록종료일, 차종s, 대수s -->
								
								<div class="row">
								<div class="col-xs-1">
									<input type="checkbox" name="selectPark" id="selectPark" value="${parkDto.parkNo}" />
								</div>
									<div class="col-xs-2">
										<img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/park/${parkDto.parkImg.imgPath}">
									</div>
									<div class="col-xs-8">								
										<h4 class="product-name" id="park">
											<strong>${parkDto.parkName}</strong>
										</h4>
										<h4>
											<small>${parkDto.parkAddr}</small>
										</h4>
										
										<!-- 확인 필요 -->
										<h4>
											<small>${parkDto.parkRegi.regiStart} ~ ${parkDto.parkRegi.regiEnd}</small><small style="color: green; font: bold;">시간당 ${parkDto.price}원</small>
										</h4>
																			
										<c:forEach items="${parkDto.carTypeList}" var="carTypes">
											<h4>
											<small>${carTypes.carType} - ${carTypes.maxCar}대</small>
											</h4>
										</c:forEach>
		
									</div>
									<div class="col-xs-1">
										<div class="col-xs-6">
											<input type="button" value="수정" id="update">
										</div>
										<br />
										<div class="col-xs-6">
											<button type="button" class="btn btn-link btn" name="deleteOne" value="${parkDto.parkNo}">
												<span class="glyphicon glyphicon-trash"> </span>
											</button>
										</div>
									</div>
								</div>
								<hr/>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</ul>
					</div>
</div>
</div>
</div>


</body>
</html>