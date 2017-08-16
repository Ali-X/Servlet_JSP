<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Category</title>
</head>
<body>
<h1>Category</h1>
<h3>Update category</h3>
<form method="post" action="<c:url value="/root/admin/category/upd"/>">
    New Category Name:<br>
    <input title="New Category Name" type="text" name="new_c_name">
    <br><br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
