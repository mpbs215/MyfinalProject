<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5a1af573ee6ab29bacc2369936a8b908&libraries=services"></script>
<script>
	window.onload = function(){
		var container = document.getElementById('map');
		var options = {
			center: new daum.maps.LatLng(33.450701, 126.570667),
			level: 3
		};
		

		var map = new daum.maps.Map(container, options);	
		
		<c:forEach items="${parkList}" var="dto">
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${dto.parkAddr}', function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === daum.maps.services.Status.OK) {

		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords,
		            clickable: true
		            
		        });

		     // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
		        var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		            iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		        // 인포윈도우를 생성합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content : iwContent,
		            removable : iwRemoveable
		        });

		        // 마커에 클릭이벤트를 등록합니다
		        daum.maps.event.addListener(marker, 'click', function() {
		              // 마커 위에 인포윈도우를 표시합니다
		              infowindow.open(map, marker);  
		        });
		        
		    } 
		});     
		</c:forEach>
	}
</script>
<script>
	$(function(){
		$("#sido").change(function(){
			alert("sido 변경");
			$("#gugun").html="";
			$("#dong").html="";
			$("#ri").html="";
			var sido=$("#sido").val();
			var options="";
			$.ajax({
				url:"${pageContext.request.contextPath}/user/selectGugun",
				data:"sido="+sido,
				dataType:"json",
				success: function(result){
 					$.each(result, function(index, item){
						options+="<option value='"+item+"'>"+item+"</option>"
					})
					$("#gugun").html(options);
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}	
			})
		})
		
		$("#gugun").change(function(){
			$("#dong").html="";
			$("#ri").html="";
			var gugun=$("#gugun").val();
			var options="";
			$.ajax({
				url:"${pageContext.request.contextPath}/user/selectDong",
				data:"gugun="+gugun,
				dataType:"json",
				success: function(result){
					alert(result)
					$.each(result, function(index, item){
						options+="<option value='"+item+"'>"+item+"</option>"
					})
					$("#dong").html(options);
				}
			})
		})
		
		$("#dong").change(function(){
			$("#ri").html="";
			var dong=$("#dong").val();
			var options="";
			$.ajax({
				url:"${pageContext.request.contextPath}/user/selectRi",
				data:"dong="+dong,
				dataType:"json",
				success: function(result){
					if(result){
						$.each(result, function(index, item){
							options+="<option value='"+item+"'>"+item+"</option>"
						})
					}
					$("#ri").html(options);
				}
			})
		})
	})
</script>
</head>
<body>	
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<div class="input-group-prepend">
				    <label class="input-group-text" for="sido">시도</label>
				</div>
				<select id="sido" class="custom-select">
					<c:forEach items="${sidoList}" var="sido">
						<option value="${sido}">${sido}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-sm-2">
				<select id="gugun" class="custom-select"></select>
			</div>
			<div class="col-sm-2">
				<select id="dong" class="custom-select"></select>
			</div>
			<div class="col-sm-2">
				<select id="ri" class="custom-select"></select>
			</div>
			<div class="col-sm-12">
				<div id="map" style="width:100%;height: 400px;"></div>
			</div>
			
			<div style="padding:5px;">
				김돈황 주차장
				2018-06-19 17:00 ~ 2018-06-20 19:00
			</div>
		</div>
	</div>
</body>
</html>