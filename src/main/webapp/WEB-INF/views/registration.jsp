<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form method="post" action="<c:url value="/root/registration"/>">
    <h4>Username:</h4>
    <input title="UserName" type="text" name="userName">
    <h4>Password:</h4>
    <input title="Password" type="password" name="password">
    <h4>Email:</h4>
    <input title="Email" type="email" name="email">
    <br>
    <br>
    <input type="submit" value="Submit">
    <br>
</form>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
