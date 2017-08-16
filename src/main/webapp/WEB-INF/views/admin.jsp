<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Admin Protected Page</title>
</head>
<body>
<h1>Hello ${requestScope.user.userName}!</h1>
<br>
<h4>Choose settings:</h4>
<a href="<c:url value="/root/admin/user"/> ">User settings</a>
<br><br>
<a href="<c:url value="/root/admin/category"/> ">Category settings</a>
<br><br>
<a href="<c:url value="/root/admin/product"/> ">Product settings</a>
<br><br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
