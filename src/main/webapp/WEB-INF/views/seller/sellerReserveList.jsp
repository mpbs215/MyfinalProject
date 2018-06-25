<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('a[data-toggle="tab"]').on('hidden.bs.tab', function(e) {
			alert("이벤트 실행됨");
		});
	});

	$('button[name="cancelReserve"]')
			.click(
					function() {
						//console.log($(this).val());

						$
								.ajax({
									url : "${pageContext.request.contextPath}/seller/sellerReserveDelete",
									dataType : "text",
									data : "reserveNo=" + $(this).val(),
									success : function(result) {
										if (result > 0) {
											alert("예약 삭제되었습니다.");
											window.location.reload();
										} else {
											alert("삭제 실패");
										}
									},
									error : function(error) {
										console.log("에러발생" + error);
									}
								})
					})
</script>

</head>
<body>

	<div class="container-fluid" style="background-color: white;">
		<div class="row justify-content-center">
			<div class="col-sm-12">

				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a
						data-target="#upcomingReserve" id="home-tab" role="tab"
						data-toggle="tab" aria-controls="home" aria-expanded="true">현재
							예약 현황</a></li>
					<li role="presentation" class=""><a data-target="#pastReserve"
						role="tab" id="profile-tab" data-toggle="tab"
						aria-controls="profile" aria-expanded="false">지난 예약 현황</a></li>
				</ul>


				<div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade active in"
						id="upcomingReserve" aria-labelledby="upcomingReserve-tab">
						<!-- 첫번째 탭 내용 -->
						<table class="table table-hover" style="align-content: center;">
							<thead>
								<tr>
									<th>주차장 이름</th>
									<th>주차 시작 시간</th>
									<th>주차 종료 시간</th>
									<th>예약자 ID</th>
									<th>예약자 이름</th>
									<th>예약자 번호</th>
									<th>예약 금액</th>
									<th>예약 취소</th>
								</tr>
							</thead>

							<tbody>
								<c:choose>

									<c:when test="${empty requestScope.reserveListLoad}">
										<tr align="center">
											<td colspan="12">
												<p align="center">
													<b><span style="font-size: 9pt;">현재 등록하신 주차장에 대한
															예약 기록이 없습니다.</span></b>
												</p>
											</td>
										</tr>
									</c:when>

									<c:otherwise>
										<c:forEach items="${requestScope.reserveListLoad}"
											var="reserveListLoad">

											<tr>
												<td><a
													href="${pageContext.request.contextPath}/예약상세페이지">${reserveListLoad.parkDto.parkName}</a></td>
												<td id="regiStart">${reserveListLoad.reserveStart}</td>
												<td id="regiEnd">${reserveListLoad.reserveEnd}</td>
												<td id="userId">${reserveListLoad.userDto.userId}</td>
												<td id="userName">${reserveListLoad.userDto.userName}</td>
												<td id="reserveNo">${reserveListLoad.userDto.hp}</td>
												<td id="price">${reserveListLoad.parkDto.price}</td>

												<td>
													<button type="button" class="btn btn-link btn"
														name="cancelReserve" value="${reserveListLoad.reserveNo}">
														<span class="glyphicon glyphicon-trash"> </span>
													</button>
												</td>
											</tr>

										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>

					</div>

					<div role="tabpanel" class="tab-pane fade" id="pastReserve"
						aria-labelledby="pastReserve-tab">
						<!-- 두번째 탭 내용 -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>주차장 이름</th>
									<th>주차 시작 시간</th>
									<th>주차 종료 시간</th>
									<th>예약자 ID</th>
									<th>예약자 이름</th>
									<th>예약자 번호</th>
									<th>예약 금액</th>
								</tr>
							</thead>

							<tbody>
								<c:choose>

									<c:when test="${empty requestScope.reserveList}">
										<tr>
											<td colspan="12">
												<p align="center">
													<b><span style="font-size: 9pt;">등록하신 주차장에 대한 지난
															예약 기록이 없습니다.</span></b>
												</p>
											</td>
										</tr>
									</c:when>

									<c:otherwise>
										<c:forEach items="${requestScope.reserveList}"
											var="reserveList">

											<tr>
												<td><a
													href="${pageContext.request.contextPath}/예약상세페이지">${reserveList.parkDto.parkName}</a></td>
												<td id="regiStart">${reserveList.reserveStart}</td>
												<td id="regiEnd">${reserveList.reserveEnd}</td>
												<td id="userId">${reserveList.userId}</td>
												<td id="userName">${reserveList.userDto.userName}</td>
												<td id="reserveNo">${reserveList.userDto.hp}</td>
												<td id="price">${reserveList.parkDto.price}</td>
												<%-- 가격 계산  --%>

											</tr>

										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>


					</div>

				</div>
			</div>
		</div>
		
		<div id="pageBar">${pageBar}</div>
		
	</div>

</body>
</html>