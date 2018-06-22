<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />
<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
<!-- Inline CSS based on choices in "Settings" tab -->
<style>
.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
	.bootstrap-iso form {
	font-family: Arial, Helvetica, sans-serif;
	color: black
}

.bootstrap-iso form button, .bootstrap-iso form button:hover {
	color: white !important;
}

.asteriskField {
	color: red;
}
</style>

<!-- datetimepicker -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<script
	src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<style type="text/css">
body {

}

#img_box {
	
}

#addedPark {
	text-align: center;
}
</style>


<script type="text/javascript">

	// 유효성 체크
	function checkValid() {
	    var f = window.document.parkRegistForm;
			
		if ( f.parkName.value == "") {
		    alert( "제목을 입력해 주세요." );
		    this.focus();
			return false;
	    }
		if ( f.parkAddr.value == "" ) {
			alert( "주차장 주소를 입력해 주세요." );
			this.focus();
			return false;
		}
		if ( f.parkSize.value == "" ) {
			alert( "주차장 면적을 입력해 주세요." );
			this.focus();
			return false;
		}
		if ( f.parkContent.value == "" ) {
	        alert( "주차장 소개를 입력해 주세요" );
	        this.focus();
	        return false;
	    }
 		if ( f.files.value == "" ) {
	        alert( "주차장 사진을 업로드해 주세요" );
	        this.focus();
	        return false;
	    } 
		if ( f.regiStart.value == "" ||  f.regiEnd.value == "" ) {
	        alert( "예약 가능 날짜와 시간 범위를 선택해 주세요" );
	        this.focus();
	        return false;
	    }
 		if ( f.regiEnd.value == "" ) {
	        alert( "예약 가능 날짜 선택해 주세요" );
	        f.this.focus();
	        return false;
	    } 
		if ( f.price.value == "" ) {
	        alert( "시간당 가격을 입력해 주세요" );
	        this.focus();
	        return false;
	    }
		
	    return true;
	}
	
	
	// 주소 검색 팝업창 띄우기
	function goPopup(){
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrCoordUrl.do)를 호출하게 됩니다.
    	var pop = window.open("${pageContext.request.contextPath}/seller/addrPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	
	// 주소 입력
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno
							, emdNo, entX, entY){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.parkRegistForm.parkAddr.value = roadFullAddr;
	}
	
	
	// 이미지 업로드 미리보기
	function fileInfo(f){
		var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

		// 파일의 갯수만큼 반복
		for(var i=0; i<file.length; i++){

			var reader = new FileReader(); // FileReader 객체 사용
			reader.onload = function(rst){
				$('#img_box').append('<img src="' + rst.target.result + '" style="max-width: 300px; max-height: 300px; border: none;"/>'); // append 메소드를 사용해서 이미지 추가
				// 이미지는 base64 문자열로 추가
				// 이 방법을 응용하면 선택한 이미지를 미리보기 할 수 있음
			}
			reader.readAsDataURL(file[i]); // 파일을 읽는다
		}
	}
	

jQuery(document).ready(
	function() {
		
		// 유효성검사
		if($("#maxCarList").val()==""){
			alert("주차 가능 대수를 입력해주세요");
	        this.focus();
	        return false;
	    }
		if($("#maxCarList").val() < 1){
	        alert( "한 대 이상을 입력해야합니다" );
	        this.val(1);
	        this.focus();
	        return false;
	    }
		
		// 날짜 선택	
		$('.datetimepicker').appendDtpicker(
			{locale : 'ko',
				autodateOnStart : false,
				todayButton: true,
				futureOnly: true
				//minDate: '${parkRegiDTO.regiStart}',
				//maxDate: '${parkRegiDTO.regiEnd}'
			}
		);
		$('.datetimepicker2').appendDtpicker(
				{locale : 'ko',
				 autodateOnStart : false,
				 todayButton: true,
				 futureOnly: true,
				}
		);
		
		// 추가 버튼 클릭시
		$("#addType").click(function(){
			//$("#addedPark").append('<tr><td><input class="form-control" type="text" readonly="readonly" name="carType" value="' + $("#carTypeSelect option:selected").text() + '"/></td><td><input class="form-control" type="text" readonly="readonly" value="1" name="maxCar" id="maxCar"/></td><td><div><img src="http://placehold.it/10x10" alt="" width="10" height="10" class="bt_up" /></div><div><img src="http://placehold.it/10x10" alt="" width="10" height="10" class="bt_down" /></div></td></tr>');
			$("#addedPark").append('<tr><td><input class="form-control" type="text" readonly name="carTypeList" id="carTypeList" value="' + $("#carTypeSelect option:selected").text() + '"/></td><td><div class="input-group"><input class="form-control" type="text" name="maxCarList" id="maxCarList"/><span class="input-group-addon"></span></div></td></tr>');

		});
					
	});
	
</script>

</head>
<body>

	<!-- HTML Form (wrapped in a .bootstrap-iso div) -->

	<div class="bootstrap-iso">

		<div class="container-fluid">

			<form name="parkRegistForm" method="post"
				action="${pageContext.request.contextPath}/seller/sellerParkRegist?${_csrf.parameterName}=${_csrf.token}"
				onSubmit='return checkValid()' enctype="multipart/form-data">
				<div class="col-sm-8">
					<div class="form-group ">
						<label class="control-label requiredField" for="parkName">
							제목 <span class="asteriskField"> * </span>
						</label> <input class="form-control" id="parkName" name="parkName"
							type="text" />
					</div>

					<div class="row">
						<div class="col-sm-8">
							<div class="form-group ">
								<label class="control-label requiredField" for="parkAddr">
									주차장 주소 <span class="asteriskField"> * </span>
								</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-home"> </i>
									</div>
									<input class="form-control" id="parkAddr" name="parkAddr"
										type="text" onclick="goPopup();" />
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group ">
								<label class="control-label requiredField" for="parkSize">
									주차장 면적 <span class="asteriskField"> * </span>
								</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-car"> </i>
									</div>
									<input class="form-control" id="parkSize" name="parkSize"
										type="text" />
								</div>
							</div>
						</div>
					</div>


					<!-- 추가 버튼 누르면 추가  -->
					<div id="carTypeSelect">
						<div class="row">
							<div class="col-sm-10">

								<div class="form-group ">
									<label class="control-label requiredField" for="carType">
										주차 가능 차종 <span class="asteriskField"> * </span>
									</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-car"> </i>
										</div>
										<table>
											<tr>
												<td><select class="select form-control"
													id="carTypeSelect" name="carTypeSelect">
														<option value="차종을 선택하세요.">차종을 선택하세요.</option>
														<option value="s">소형</option>
														<option value="m">중형</option>
														<option value="l">대형</option>
												</select></td>
												<td style="padding-left: 30px;"><input class="btn" type="button" id="addType" value="추가" style="background-color: white; border-color: black;"/></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<label class="control-label requiredField" for="parkContent">
								주차장 소개 <span class="asteriskField"> * </span>
							</label>
							<textarea class="form-control" cols="40" id="parkContent"
								name="parkContent"
								placeholder="더욱 많은 사용자가 예약할 수 있도록 장점, 랜드마크 등의 주차장 소개를 작성해주세요. (작성한 내용은 키워드로 검색됩니다.)"
								rows="10"></textarea>
						</div>

						<!-- 이미지 업로드 -->
						<div class="form-group ">
							<label class="control-label requiredField" for="files">
								주차장 사진 (여러장 선택 가능)<span class="asteriskField"> * </span>
							</label>
							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-file-image-o"> </i>
								</div>

								<input class="form-control" type="file" name="files"
									accept="image/*" multiple onchange="fileInfo(this)"
									placeholder="주차장 사진을 등록해주세요.(여러장 업로드시 한번에 추가해주세요.)">
								<div id="img_box"></div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-4">

					<div class="text-center border rounded">
						<br />
						<div class="form-group ">

							<label class="control-label requiredField" for=""> 예약 가능
								날짜<span class="asteriskField"> * </span>
							</label> <br />
							<div class="row justify-content-center">
								<div class="col-sm-5">
									<input type="text" class='datetimepicker' name="regiStart"
										id="regiStart">
								</div>
								<div class="col-sm-1">~</div>
								<div class="col-sm-5">
									<input type="text" class='datetimepicker2' name="regiEnd"
										id="regiEnd">
								</div>
							</div>
							<br />

							<div class="row justify-content-center">
								<div class="col-sm-11">
									<label class="control-label requiredField" for="price">
										시간당 가격(원) <span class="asteriskField"> * </span>
									</label>
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-money"> </i>
										</div>
										<input class="form-control" id="price" name="price"
											type="text" />
									</div>
								</div>
							</div>
							<br />

							<div class="row justify-content-center">
								<div class="col-sm-11">
									<div style="background-color: #F2F2F2;">
										<table id="addedPark" style="margin: 20px;">
											<tr>
												<td>주차 가능 차종</td>
												<td>주차 가능 대수</td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>

						<br />
						<div class="form-group">
							<div align="center">
								<button class="btn" name="submit" type="submit" style="background-color: #04B404; color: white;">주차장 등록하기</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
