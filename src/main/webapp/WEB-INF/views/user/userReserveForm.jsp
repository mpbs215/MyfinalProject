<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/fullcalendar.min.css" rel='stylesheet'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/fullcalendar.print.min.css" rel='stylesheet' media='print' >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/scheduler.min.css" rel='stylesheet'>
<script src='${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/jquery.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/fullcalendar.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/scheduler.min.js'></script>

<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script> -->
<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

<style type="text/css">
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>

<script type="text/javascript">
$(function(){
			 $("#calendar").fullCalendar({
				 schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
			      now: new Date,
			      editable: true,
			      aspectRatio: 1.8,
			      scrollTime: '00:00',
			      header: {
			        left: 'today prev,next',
			        center: 'title',
			        right: 'timelineDay,timelineTenDay,timelineMonth,timelineYear'
			      },
			      defaultView: 'timelineDay',
			      views: {
			        timelineDay: {
			          buttonText: '15개 보기',
			          slotDuration: '01:00'
			        },
			        timelineTenDay: {
			          buttonText: '10일 보기',
			          type: 'timeline',
			          duration: { days: 10 }
			        }
			      },
			      editable : false,
			      monthNames : [ "1월", "2월", "3월", "4월",
						"5월", "6월", "7월", "8월", "9월",
						"10월", "11월", "12월" ],
				  monthNamesShort : [ "1월", "2월", "3월", "4월",
									"5월", "6월", "7월", "8월", "9월",
									"10월", "11월", "12월" ],
			      navLinks: true,
			      resourceAreaWidth: '25%',
			      resourceLabelText: '차종',
			      resources: [
			        { id: '소형', title: '소형', eventColor: 'red' },
			        { id: '중형', title: '중형', eventColor: 'green' },
			        { id: '대형', title: '대형', eventColor: 'orange' },
			      ],
			      events:  reservedataList
			    })
					$("input[name='reserveStart']").appendDtpicker(
						{locale : 'ko',
						 autodateOnStart : false,
						 todayButton: false,
						 futureOnly: true,
						 minDate: '${parkRegiDTO.regiStart}',
						 maxDate: '${parkRegiDTO.regiEnd}'
						}
					);
					$("input[name='reserveEnd']").appendDtpicker(
							{locale : 'ko',
							 autodateOnStart : false,
							 todayButton: false,
							 futureOnly: true,
							 minDate: '${parkRegiDTO.regiStart}',
							 maxDate: '${parkRegiDTO.regiEnd}'
							}
					);

 					$("input[name='reserveStart']").change(function() {
 						$("input[name='reserveEnd']").val("");
					});
					
 					$("input[name='reserveEnd']").change(function() {
						 if($("input[name='reserveEnd']").val()<$("input[name='reserveStart']").val()){
							 alert("시작시간보다 이후 시간을 선택해주세요.");
							 $("input[name='reserveEnd']").val("");
						 }
						 if($("input[name='reserveEnd']").val() && $("input[name='reserveStart']").val() && $("[name='carType']").val()){
							reserveCheck();
						 }
						 
					});
 					
 					$("[name='carType']").change(function(){
						 if($("input[name='reserveEnd']").val() && $("input[name='reserveStart']").val() && $("[name='carType']").val()){
								reserveCheck();
						 }
 					});
					
					$(".star").on('click',document,function(){
						var data="";
						var star="";
						switch ($(this).attr("name")) {
						  case '1': star="★☆☆☆☆"; break;
						  case '2': star="★★☆☆☆"; break;
						  case '3': star="★★★☆☆"; break;
						  case '4': star="★★★★☆"; break;
						  case '5': star="★★★★★"; break;
						}
						$.ajax({
							url: "${pageContext.request.contextPath}/user/userClickReviewStar",
							data: "rating="+$(this).attr("name")+"&parkNo="+${parkDTO.parkNo},
							dataType: "json",
							success: function(result){
								$("#reviewContent").html("");
								 $.each(result, function(index, item){
									data+="<div class='col-sm-2 font-weight-bold'>";
									data+=star+"</div>";
									data+="<div class='col-sm-8 font-weight-bold'>";
									data+=item.reviewContent+"</div>"
									data+="<div class='col-sm-2 font-weight-bold'>";
									data+=item.userId+"</div>"
									data+="<div class='col-sm-12'><hr /></div>";
									$("#reviewContent").append(data);
								 })
							},
							error:function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}							
						})
					})//리뷰 갱신 end
					//차량 및 날짜 갱신시 예약 가능 여부 체크
					function reserveCheck(){
						alert("체크 호출")
						var queryString = $("form[name=reservation]").serialize() ;
						$.ajax({
							url: "${pageContext.request.contextPath}/user/reserveCheck",
							data: queryString,
							dataType : 'text',
							success: function(result){
								alert(result)
								if(result=="OK"){
									$("#reserveBtn").attr("disabled",false);
									$("#reserveBtn").val("예약하기");
									$("#reserveBtn").attr("class","btn btn-primary");
								}else if(result=="No"){
									$("#reserveBtn").attr("disabled",true);
									$("#reserveBtn").val("예약불가");
									$("#reserveBtn").attr("class","btn btn-danger");
								}
							},
							error:function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						})
					}
	}
)
</script>
</head>
<body>
	<c:if test="${empty parkReserveList}">
		<script>
		var reservedataList = null;
		</script>
	</c:if>
	<c:forEach items="${parkReserveList}" var="dto" varStatus="status">
		
		<script type="text/javascript">
		if(${status.count}==1){	
			var reservedataList = new Array();
		}
 		var reservedata= new Object();
 		reservedata.id = '${status.count}';
 		reservedata.resourceId = '${dto.carType}';
 		reservedata.start = '${dto.reserveStart}';
 		reservedata.end = '${dto.reserveEnd}';
 		reservedata.title = '${dto.userId}';
 		JSON.stringify(reservedata);
 		reservedataList.push(reservedata);
 		</script>
	</c:forEach>
	<div class="container">
		<div class="row" style="height: 25%"></div>
		<div class="row">
			<h3 class="text-center font-weight-bold text-primary" style="text-shadow: 1px 1px 1px #0054FF;">&nbsp&nbsp주차장 예약하기</h3>
			<p />
			<hr style="width: 100%; border: 2px solid #0054FF;" />
		</div>
		<div class="row" style="background-color: height: 150%;">
			<div class="col-sm-7">
				<div id="arrowslider" class="row justify-content-center carousel slide" data-ride="carousel">
					  <div class="carousel-inner" role="listbox">
 					  	<c:forEach items="${parkImageList}" var="dto" varStatus="status" >
					  	<div class="carousel-item <c:if test="${status.count==1}">active</c:if>" >
					      <img class="d-block img-fluid" src="${pageContext.request.contextPath}/resources/images/park/${dto.imgPath}" alt="Slide${status.count}" style="width:95%; margin-left: 2.5%">
					    </div>
					  	</c:forEach>
					  	    <div class="carousel-item active">
						      <img class="d-block img-fluid" src="http://www.stc-corp.co.kr/pages/image/led/led11.jpg" alt="Slide1" style="width:95%; margin-left: 2.5%">
						    </div>
						    <div class="carousel-item">
						      <img class="d-block img-fluid" src="https://img.webnots.com/2017/05/BS_Slide2.jpg" alt="Slide2" style="width:95%; margin-left: 2.5%">
						    </div>
						    <div class="carousel-item">
						      <img class="d-block img-fluid" src="https://img.webnots.com/2017/05/BS_Slide3.jpg" alt="Slide3" style="width:95%; margin-left: 2.5%">
						    </div>
					  </div>
					  <a class="carousel-control-prev" href="#arrowslider" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous Slide</span>
					  </a>
					  <a class="carousel-control-next" href="#arrowslider" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next Slide</span>
					  </a>
				</div>
				<div class="row justify-content-center">
					<table class="table" style="width: 95%">
						<tr>
							<th class="bg-primary text-white">주차장 이름</th>
							<th>${parkDTO.parkName}</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">판매자</th>
							<th>${parkDTO.userId}</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">주차 차종</th>
							<th>
							<c:forEach items="${carTypeList}" var="dto">
							${dto.carType}
							</c:forEach>
							</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">주차 대수</th>
							<th>
							<c:forEach items="${carTypeList}" var="dto">
							${dto.carType}:${dto.maxCar}
							</c:forEach>
							</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">시간당 가격</th>
							<th>${parkDTO.price}</th>
						</tr>
					</table>
					<br />
				</div>
				<div class="container">
					<b>
					이 주차장은 주차주차주차주차한 공간으로 주차주차주차합니다. 주차주차하세요. OK 주차장 is 완벽 is 굳
					굳 굳 베리 굳 굳 굳
					</b>
					<br />
				</div>
				<div>
					<br />
					<h3 class="font-weight-bold">&nbsp&nbsp구매평</h3>
					<p />
					<hr style="width: 100%; border: 1px solid #0054FF;" />
				</div>
				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning star" name="5">★★★★★</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning star" name="4">★★★★☆</button>

					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning star" name="3">★★★☆☆</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning star" name="2">★★☆☆☆</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning star" name="1">★☆☆☆☆</button>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-outline-warning star" name="0">&reg;</button>
					</div>
				</div>
				<br />
				<div class="row justify-content-center" id="reviewContent">
					<c:forEach items="${reviewList}" var="dto">
					<div class="col-sm-2 font-weight-bold">
					<c:choose>
						<c:when test="${dto.rating==5}">
							★★★★★
						</c:when>
						<c:when test="${dto.rating==4}">
							★★★★☆
						</c:when>
						<c:when test="${dto.rating==3}">
							★★★☆☆
						</c:when>
						<c:when test="${dto.rating==2}">
							★★☆☆☆
						</c:when>
						<c:when test="${dto.rating==1}">
							★☆☆☆☆
						</c:when>
					</c:choose>
					</div>
					<div class="col-sm-8 font-weight-bold">
					${dto.reviewContent}
					</div>
					<div class="col-sm-2 font-weight-bold">${dto.userId}</div>
					<div class="col-sm-12"><hr /></div>
					</c:forEach>
				</div>
				<form action="${pageContext.request.contextPath}/user/insertReview" method="post" class="row justify-content-center"> 
					<select name="rating" class="text-warning custom-select" style="height: 30px">
					<option value="5">★★★★★</option>
					<option value="4">★★★★☆</option>
					<option value="3">★★★☆☆</option>
					<option value="2">★★☆☆☆</option>
					<option value="1">★☆☆☆☆</option>
					</select> 
					<b class="text-primary">평점 및 후기를 남겨주세요.</b>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<input type="hidden" name="parkNo" value="${parkDTO.parkNo}" >
					<textarea rows="5" cols="" class="form-control" name="reviewContent"></textarea>
					<button type="submit" class="btn btn-primary form-control">리뷰올리기</button>
				</form> 
			</div>
			<div class="col-sm-5">
				<div id="calendar"></div>
				<br />
				<div>
					<table class="text-center text-white" style="width:100%;border: 1px solid black;">
						<tr>
							<th colspan="3" class="bg-info">최대 예약 수</th>
						</tr>
						<tr class="text-primary">
						<c:forEach items="${carTypeList}" var="dto">
							<th>${dto.carType}</th>
						</c:forEach>
						</tr>
						<tr class="text-secondary">
						<c:forEach items="${carTypeList}" var="dto">
							<th>${dto.maxCar}</th>
						</c:forEach>
						</tr>
					</table>
				</div>
				<br />
				<form action="${pageContext.request.contextPath}/user/reservation" name="reservation" method="post">
				<div class="text-center border rounded">
					<h6 class="font-weight-bold form-control bg-success text-white">예약 날짜 선택하기</h6> 
					<div class="row"><br /></div>
					<div class="row justify-content-center">
						<div class="col-sm-5"><input type="text" name="reserveStart" readonly="readonly"></div>
						<div class="col-sm-2">~</div>
						<div class="col-sm-5"><input type="text" name="reserveEnd" readonly="readonly"></div>
					</div>
					<div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<input type="hidden" name="parkNo" value="${parkDTO.parkNo}" />
						<p></p>
						<select name="carType" class="custom-select" style="height: 40px">
						<c:forEach items="${carTypeList}" var="dto">
						<option value="${dto.carType}">${dto.carType}</option>
						</c:forEach>
						</select> 
						<p></p>
						<input type="submit" class="btn btn-primary" id="reserveBtn" value="예약하기"/>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>