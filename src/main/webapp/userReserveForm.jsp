<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/fullcalendar.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/fullcalendar.print.css"
	rel="stylesheet" media="print" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/lib/moment.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/fullcalendar-3.9.0/fullcalendar.js"></script>
<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
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
	jQuery(document).ready(
		function() {
			jQuery("#calendar")
				.fullCalendar({
							header : {
							left : "",
							center : "title",
							right : "today prev,next"
							},
						navLinks : true,
						editable : false,
						monthNames : [ "1월", "2월", "3월", "4월",
										"5월", "6월", "7월", "8월", "9월",
										"10월", "11월", "12월" ],
						monthNamesShort : [ "1월", "2월", "3월", "4월",
										"5월", "6월", "7월", "8월", "9월",
										"10월", "11월", "12월" ],
						dayNames : [ "일요일", "월요일", "화요일", "수요일",
										"목요일", "금요일", "토요일" ],
						dayNamesShort : [ "일", "월", "화", "수", "목",
									"금", "토" ],
						eventLimit : false,
						dayClick : false,
						buttonText : {
						today : "오늘",
						month : "월별",
						week : "주별",
						day : "일별",
						},
						navLinks : false,
						defaultView : "month",
						timeFormat: 'H(:mm)',
						events : [ 
						{
						id : 123,
						title : "돈황이 테스트",
						start : "2018-06-01T10:30:00",
						end : "2018-06-11T18:00:00",
						allDay: false
						},
						]
					});
					$('.datetimepicker').appendDtpicker(
						{locale : 'ko',
						 startDate : '2018/06/13',
						 autodateOnStart : false,
						 todayButton: false,
						 futureOnly: true,
						}
					);
					$(".datetimepicker").change(function(){
					    
					});
					$('.datetimepicker2').appendDtpicker(
							{locale : 'ko',
							 startDate : '2018/06/13',
							 autodateOnStart : false,
							 todayButton: false,
							 futureOnly: true,
							}
					);
					
			}
		$('#star').click(function(){
			var data="";
			var star="";
			switch ($(this).attr("name")) {
			  case 1: star="★☆☆☆☆"; break;
			  case 2: star="★★☆☆☆"; break;
			  case 3: star="★★★☆☆"; break;
			  case 4: star="★★★★☆"; break;
			  case 5: star="★★★★★"; break;
			}
			$.ajax({
				url: "${pageContext.request.contextPath}/user/userClickReviewStar",
				data: "rating="+$(this).attr("name")+"&parkNo="+${parkDTO.parkNo},
				dataType: "json",
				sucess: function(result){
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
				}
			})
		})
	);
</script>
</head>
<body>
	<div class="container">
		<div class="row" style="height: 25%"></div>
		<div class="row">
			<h3 class="text-center font-weight-bold text-primary" style="text-shadow: 1px 1px 1px #0054FF;">&nbsp&nbsp주차장 예약하기</h3>
			<p />
			<hr style="width: 100%; border: 2px solid #0054FF;" />
		</div>
		<div class="row" style="background-color: height: 150%;">
			<div class="col-sm-7">
				<div class="row justify-content-center">
					<img
						src="http://image.chosun.com/sitedata/image/201706/29/2017062901812_0.jpg"
						class="rounded" alt="sample" width="95%" height="40%" />
				</div>
				<div class="row justify-content-center">
					<table class="table" style="width: 95%">
						<tr>
							<th class="bg-primary text-white">주차장 이름</th>
							<th>${parkDTO.parkName} 잘생긴 주차장</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">판매자</th>
							<th>${parkDTO.userId} 김돈황</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">주차 차종</th>
							<th>소형, 중형</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">주차 대수</th>
							<th>소2, 중2</th>
						</tr>
						<tr>
							<th class="bg-primary text-white">시간당 가격</th>
							<th>3000원</th>
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
						<button type="button" class="btn btn-outline-warning" id="star" name="5">★★★★★</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning" id="star" name="4">★★★★☆</button>

					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning" id="star" name="3">★★★☆☆</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning" id="star" name="2">★★☆☆☆</button>
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-outline-warning" id="star" name="1">★☆☆☆☆</button>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-outline-warning" id="star">&reg;</button>
					</div>
				</div>
				<br />
				<div class="row justify-content-center" id="reviewContent">
					<div class="col-sm-2 font-weight-bold">
					★★★★☆
					</div>
					<div class="col-sm-8 font-weight-bold">
					이 주차장은 좁아터져서 주차할곳이 없는듯 ㅗㅗ
					쓰지마세요. 두번마세요 엿이나 먹어라 에바참지 개오바 억지 억억
					으아아아아아아아아아아아아아아아아아아아아아아아아아아아아
					</div>
					<div class="col-sm-2 font-weight-bold">김돈황</div>
					<div class="col-sm-12"><hr /></div>
					<div class="col-sm-2 font-weight-bold">
					★★★★☆
					</div>
					<div class="col-sm-8 font-weight-bold">
					이 주차장은 좁아터져서 주차할곳이 없는듯 ㅗㅗ
					쓰지마세요. 두번마세요 엿이나 먹어라 에바참지 개오바 억지 억억
					으아아아아아아아아아아아아아아아아아아아아아아아아아아아아
					</div>
					<div class="col-sm-2 font-weight-bold">김돈황</div>
					<div class="col-sm-12"><hr /></div>
					<div class="col-sm-2 font-weight-bold">
					★★★★☆
					</div>
					<div class="col-sm-8 font-weight-bold">
					이 주차장은 좁아터져서 주차할곳이 없는듯 ㅗㅗ
					쓰지마세요. 두번마세요 엿이나 먹어라 에바참지 개오바 억지 억억
					으아아아아아아아아아아아아아아아아아아아아아아아아아아아아
					</div>
					<div class="col-sm-2 font-weight-bold">김돈황</div>
					<div class="col-sm-12" style="margin-top: 15px">
					</div>
				</div>
				<form action="#" method="get" class="row justify-content-center"> 
					<select name="rating" class="text-warning custom-select" style="height: 30px">
					<option value="5">★★★★★</option>
					<option value="4">★★★★☆</option>
					<option value="3">★★★☆☆</option>
					<option value="2">★★☆☆☆</option>
					<option value="1">★☆☆☆☆</option>
					</select> 
					<b class="text-primary">평점 및 후기를 남겨주세요.</b>
					<textarea rows="5" cols="" class="form-control"></textarea>
					<button type="submit" class="btn btn-primary form-control">리뷰올리기</button>
				</form> 
			</div>
			<div class="col-sm-5">
				<div id="calendar"></div>
				<div>
					<b class="bg-danger">----</b>
				</div>
				
				<br />
				<form action="#" method="post">
				<div class="text-center border rounded">
					<h6 class="font-weight-bold form-control bg-success text-white">예약 날짜 선택하기</h6> 
					<div class="row"><br /></div>
					<div class="row justify-content-center">
						<div class="col-sm-5"><input type="text" class='datetimepicker' name=""></div>
						<div class="col-sm-2">~</div>
						<div class="col-sm-5"><input type="text" class='datetimepicker2' name=""></div>
					</div>
					<div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<button type="submit" class="btn btn-primary">예약하기</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>