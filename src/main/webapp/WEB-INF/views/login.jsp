<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ali-X
  Date: 24.07.2017
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="<c:url value="/root/login"/>">
        Login:<br>
        <input title="UserName" type="text" name="userName">
        <br><br>
        Password:<br>
        <input title="Password" type="password" name="password">
        <br><br>
        <input type="submit" value="Submit">
        <br><br>
        <a href="<c:url value="/root/registration"/> ">Registration</a>
    </form>
    <a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
