<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Product</title>
</head>
<body>
<h1>Product</h1>
<h3>Update product</h3>
<form method="post" action="<c:url value="/root/admin/product/upd"/>">
    New Product Name:<br>
    <input title="New Product Name" type="text" name="new_p_name">
    <br><br>
    Product description:<br>
    <input title="Product description" type="text" name="p_descr">
    <br><br>
    Category Name:<br>
    <select name="c_name">
        <c:forEach var="cat" items="${categories}">
            <option value="${cat.name}">${cat.name}</option>
        </c:forEach>
    </select>
    <br><br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="Submit">
</form>
</body>
</html>
