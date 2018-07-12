<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
</head>
<body>
	<form action="customerImport.action" method="post"
		enctype="multipart/form-data">
		<input type="file" value="选择文件" name="exel"> <input
			type="submit" value="导入文件">
	</form>

	<button onclick="exelExport()">导出</button>

	<form action="getCustomerListByName.action" method="get">
		<input type="text" name="job" value="${job}">
		<input type="submit" value="查询">
	</form>

	<table border="1" width="100%" cellpadding="10" cellspacing="10"
		style="border-collapse:collapse">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>birthday</th>
			<th>job</th>
			<th>company</th>
			<th>tel</th>
			<th>address</th>
		</tr>
		<c:forEach var="customer" items="${customerList}">
			<tr>
				<!-- "${customer}"不能有空格 -->
				<td><c:out value="${customer.id}"></c:out></td>
				<td><c:out value="${customer.name}"></c:out></td>
				<td><c:out value="${customer.age}"></c:out></td>
				<td><c:out value="${customer.birthday}"></c:out></td>
				<td><c:out value="${customer.job}"></c:out></td>
				<td><c:out value="${customer.company}"></c:out></td>
				<td><c:out value="${customer.tel}"></c:out></td>
				<td><c:out value="${customer.address}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">
    /* 导出到exel表 */
	function exelExport() {
		$.ajax({
			url : "exelExport.action",
			success : function(data) {
				if (data == 'ok') {
					alert('success')
				}
			},
			error : function(data) {
				alert("fail")
			}
		})
	}
</script>

</html>