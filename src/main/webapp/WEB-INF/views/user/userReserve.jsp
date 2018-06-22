<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5a1af573ee6ab29bacc2369936a8b908&libraries=services"></script>
<script>
$(function(){
	var container = document.getElementById('map');
	var options = {
		center: new daum.maps.LatLng(33.450701, 126.570667),
		level: 3
	};
	

	var map = new daum.maps.Map(container, options);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	
	$("input[name='reserveDate']").appendDtpicker(
			{locale : 'ko',
			 autodateOnStart : false,
			 todayButton: true,
			 futureOnly: true,
			}
	);
	
	function markerRenew(){
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
	}
})
</script>
<script>
	$(function(){
		$("#sido").change(function(){
			$("[name='parkAddr']").val($("#sido").val())
			$("#gugun").html="";
			$("#dong").html="";
			$("#ri").html="";
			var sido=$("#sido").val();
			var options="<option value=''></option>";
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
			$("[name='parkAddr']").val($("#gugun").val())
			$("#dong").html="";
			$("#ri").html="";
			var gugun=$("#gugun").val();
			var options="<option value=''></option>";
			$.ajax({
				url:"${pageContext.request.contextPath}/user/selectDong",
				data:"gugun="+gugun,
				dataType:"json",
				success: function(result){
					$.each(result, function(index, item){
						options+="<option value='"+item+"'>"+item+"</option>"
					})
					$("#dong").html(options);
				}
			})
		})
		
		$("#dong").change(function(){
			$("[name='parkAddr']").val($("#dong").val())
			$("#ri").html="";
			var dong=$("#dong").val();
			var options="<option value=''></option>";
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
		$("#ri").change(function(){
			$("[name='parkAddr']").val($("#ri").val())
		})
		///////////////////////시도구군동리 셀렉트바 끝/////////////////////
		$("#keyWord").change(function(){
			//alert("키워드 변경")
			$("#dataType").attr("name",$("#keyWord").val())
			if($("#dataType").attr("name")=='price'){
				$("#dataType").attr("type","number")
			}else{
				$("#dataType").attr("type","text")
			}
			//alert($("#dataType").attr("name"))
		})
		$("#search").click(function(){
			parkChange()
		})
		function parkChange(){
			
			var queryString = $("form[name=searchData]").serialize();
			alert(queryString);
 			$.ajax({
				url:"${pageContext.request.contextPath}/user/renewParkList",
				data:queryString,
				dataType: "json",
				success : function(result){
					alert("성공")
 					$.each(result, function(index, item){
						  var parkList = new Array();
						  parkList[0] = item.parkName;
						  parkList[1] = item.parkAddr;
						  parkList[2] = item.parkRegi.regiStart;
						  parkList[3] = item.parkRegi.regiEnd;
						  parkList[4] = item.price;
						  console.log(parkList)
					})
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
				
			}) 
		}
		parkChange();
	})
</script>
</head>
<body>	
	<div class="container">
		<form name="searchData">
			<div class="row">
				<div class="col-sm-2">
					<select id="sido" class="custom-select">
						<option value=""></option>
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
				<div class="col-sm-2">
					<input type="text" name="reserveDate" readonly="readonly" class="form-control"/>
				</div>
			
				<div class="col-sm-2">
					<select name="carType" class="custom-select">
						<option value=""></option>
						<option value="대형">대형</option>
						<option value="중형">중형</option>
						<option value="소형">소형</option>
					</select>
				</div>
				<br />
				<div class="col-sm-12">
					<div id="map" style="width:100%;height: 400px;"></div>
				</div>
				<div class="col-sm-6">
					<input type="hidden" name="parkAddr"/>
				</div>
				<div class="col-sm-2">
					<select id="keyWord" class="custom-select">
						<option value="destination">목적지</option>
						<option value="parkName">주차장이름</option>
						<option value="price">가격(이하)</option>
						<option value="parkContent">내용</option>
					</select>
				</div>
				<div class="col-sm-4">
					<input type="text" name="" id="dataType" class="form-control" style="width:65%; display: inline-block;"/>
					<button type="button" class="btn btn-primary" id="search">검색</button>
				</div>
			  </div>
			</form>
			
			<div style='width: 600px;height: 230px; display: inline-block; border: 1px solid black'>
				<div style='width:40%; height: 100%; display: inline-block;'>
					<img src='http://www.pusan1st.com/data/franchise2/246/thumb-7KO87LCo1_385x230.png' width='100%' height='100%'>
				</div>
				<div style='width:60%; height: 100%; display: inline-block; float: right'>
					<ul class='list-group list-group-flush border'>
					  <li class='list-group-item bg-primary text-white font-weight-bold'>서울 주차장</li>
					  <li class='list-group-item' >서울 은평구 불광동 8-63번지 201호</li>
					  <li class='list-group-item' >
					  item.parkName item.parkAddr item.parkRegi.regiStart item.parkRegi.regiEnd item.price
					  2018-06-20 18:00:00 <br />
					  ~ 2018-06-20 19:00:00
					  </li>
					  <li class='list-group-item' > 가격: 2000 / 중형1 소형2 대형3</li>
					</ul>
				</div>
			</div>
		</div>
</body>
</html>