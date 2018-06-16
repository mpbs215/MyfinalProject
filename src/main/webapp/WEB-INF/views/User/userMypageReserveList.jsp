<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<div class="container">
  <h2>Card Image</h2>
  <p>Image at the top (card-img-top):</p>
  <div class="card" style="width:350px">
    <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfYd4sPXgvAVg45xPTLvQRz_02LPY6_3jq756m0tKCyXmWaI1s" alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">예약 1</h4>
      <p class="card-text">간단한 정보</p>
      <div style = "float:right;">
      <a href="../User/userMypageReserveDetail" class="btn btn-success">Detail</a>
    </div>
    </div>
  </div>
  <br>
</body>
</html>