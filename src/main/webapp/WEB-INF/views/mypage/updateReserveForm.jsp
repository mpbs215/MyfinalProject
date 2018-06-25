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
<script>
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
				
				function reserveCheck(){
					var queryString = $("form[name=reservation]").serialize() ;
					$.ajax({
						url: "${pageContext.request.contextPath}/user/reserveCheck",
						data: queryString,
						dataType : 'text',
						success: function(result){
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
				$('#reserveBtn').click(function(){
					var queryString = $("form[name=reservation]").serialize() ;
					$.ajax({
						url: "${pageContext.request.contextPath}/user/updateReservation",
						data: queryString,
						success: function(){
							opener.parent.location.reload();
							self.close();
						}
					})
				})
	})

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
			<div class="col-sm-12">
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
				<form action="${pageContext.request.contextPath}/user/updateReservation" name="reservation" method="post">
				<div class="text-center border rounded">
					<h6 class="font-weight-bold form-control bg-success text-white">예약 날짜 선택하기</h6> 
					<div class="row"><br /></div>
					<div class="row justify-content-center">
						<div class="col-sm-5"><input type="text" name="reserveStart" readonly="readonly" ></div>
						<div class="col-sm-2">~</div>
						<div class="col-sm-5"><input type="text" name="reserveEnd" readonly="readonly" ></div>
					</div>
					<div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<input type="hidden" name="parkNo" value="${parkDTO.parkNo}" />
						<input type="hidden" name="reserveNo" value="${reserveNo}">
						<p></p>
						<select name="carType" class="custom-select" style="height: 40px">
						<c:forEach items="${carTypeList}" var="dto">
						<option value="${dto.carType}">${dto.carType}</option>
						</c:forEach>
						</select> 
						<p></p>
						<input type="button" class="btn btn-primary" id="reserveBtn" value="예약변경하기" disabled="disabled"/>
					</div>
				</div>
				</form>
				
			</div>
	</div>
</body>
</html>