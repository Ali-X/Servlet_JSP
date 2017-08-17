<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>User Page</title>
</head>
<body>
<h1>Hello, ${requestScope.user.userName}</h1>
<br>
<table>
    <tr>
        <td>
            <h2>Name:</h2>
            <h4><c:out value="${requestScope.user.userName}"/></h4>
            <h2>Password:</h2>
            <h4><c:out value="${requestScope.user.password}"/></h4>
            <h2>Email:</h2>
            <h4><c:out value="${requestScope.user.email}"/></h4>
        </td>
        <td>
            <h2>Image:</h2>
            <img src="${pageContext.request.contextPath}/images/${requestScope.user.userName}.png" alt="Image"
                 width="200" height="200"/>
        </td>
    </tr>
</table>
<br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
