<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
  </head>
  
  <body>
  HJhjdsdds
    <div id="main" style="width:800px;height:600px"></div>
  </body>
  <script type="text/javascript">
  	var myChart = echarts.init(document.getElementById("main"));
  	var option = {
	    xAxis: {
	        type: 'category',
	        data: []
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [],
	        type: 'bar'
	    }]
	};
	
	myChart.setOption(option);
	
	myChart.showLoading();
	
	var x = [];
	var y = [];
	$.ajax({
		url:'chart.action',
		type:'post',
		dataType:'json',
		success:function(data){
			for(var i = 0 ; i < data.length ; i++){
				x.push(data[i].name);
				y.push(data[i].value)
			}
			myChart.hideLoading();
			myChart.setOption({
				xAxis: {
	        		data: x
	    		},
	    		series: [{
	        		data: y,
	    		}]
			});
		},
	})
  </script>
</html>
