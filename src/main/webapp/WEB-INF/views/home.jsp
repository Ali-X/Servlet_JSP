<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome!</h1>
    <a href="<c:url value="/root/login"/> ">Log in</a>
    <br><br>
    <a href="<c:url value="/root/profile"/> ">My Profile</a>
</body>
</html>
