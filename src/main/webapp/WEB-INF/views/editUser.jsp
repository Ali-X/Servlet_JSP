<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ali-X
  Date: 17.08.2017
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>User</title>
</head>
<body>
<h1>Product</h1>
<h3>Update user</h3>
<form method="post" action="<c:url value="/root/admin/user/upd"/>" enctype="multipart/form-data">
    <h4>Username:</h4>
    <input title="UserName" type="text" name="userName">
    <h4>Password:</h4>
    <input title="Password" type="password" name="password">
    <h4>Email:</h4>
    <input title="Email" type="email" name="email">
    <br>
    <h4>Image:</h4>
    <input type="file" name="file" title="select image..."/>
    <br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Submit">
    <br>
</form>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
