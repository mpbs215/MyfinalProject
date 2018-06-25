<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
	
	function call(){
		$.ajax({
			url:"${pageContext.request.contextPath}/seller/callStats",
			data: "startDate="+$('#startDate').val()+"endDate"+$('#endDate').val(),
			dataType: "json",
			success : function(result){
				var chartData=""
				$.each(result, function(index, item){
					chartData+="{name: "+item.parkName+",y:"+ item.price+",sliced: true,selected: true},"
				})
				console.log(chartData);
				chartCall(chartData);
			}
		})
	}
	
	function chartCall(chartData){
		Highcharts.chart('container', {
		  chart: {
		    plotBackgroundColor: null,
		    plotBorderWidth: null,
		    plotShadow: false,
		    type: 'pie'
		  },
		  title: {
		    text: '주차장 별 수익 비중'
		  },
		  tooltip: {
		    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		  },
		  plotOptions: {
		    pie: {
		      allowPointSelect: true,
		      cursor: 'pointer',
		      dataLabels: {
		        enabled: true,
		        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		        style: {
		          color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
		        }
		      }
		    }
		  },
		  series: [chartData
			
		  ]
		});
	}
	call()
	$('#new').click(function(){
		call()
	})
	
})
</script>
<div class="container">
<input type="text" id="startDate" /> ~ <input type="text" id="endDate" /> <input type="button" value="갱신" id="new"/>
<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
</div>