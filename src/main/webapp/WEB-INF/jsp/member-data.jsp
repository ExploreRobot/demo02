<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/7/9
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>id</th>
    <th>name</th>
    <c:forEach items="${list}" var="member">
        <tr>
            <td>${member._id}</td>
            <td>${member.m_name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
