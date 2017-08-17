<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Home Page</title>
</head>
<body>
<h1>Welcome!</h1>
<br>
<a class="button" href="<c:url value="/root/login"/> ">Log in</a>
<br><br>
<a class="button" href="<c:url value="/root/profile"/> ">My Profile</a>
<br><br>
<a class="button" href="<c:url value="/root/categories"/> ">Categories</a>
</body>
</html>
