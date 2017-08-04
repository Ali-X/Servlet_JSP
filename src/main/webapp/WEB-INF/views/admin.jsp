<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Protected Page</title>
</head>
<body>
<h1>Admin Protected Page</h1>
    Hello ${requestScope.user.userName}!
<br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
