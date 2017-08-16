<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="<c:url value="/root/login"/>">
    <h4>Username:</h4>
    <input title="UserName" type="text" name="userName">
    <h4>Password:</h4>
    <input title="Password" type="password" name="password">
    <br>
    <input type="submit" value="Submit">
    <br>
    <a href="<c:url value="/root/registration"/> ">Registration</a>
</form>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
