<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Products</title>
</head>
<body>
<h1>Products:</h1>
<br>
<h4>Choose product:</h4>
<div class="dropdown">
    <button class="dropbtn">Products</button>
    <div class="dropdown-content">
        <c:forEach var="pr" items="${products}">
            <a class="menu" href="
                                <c:url value="/root/product">
                                    <c:param name="c_id" value="${param.c_id}" />
                                    <c:param name="p_id" value="${pr.id}" />
                                </c:url>
                            "><c:out value="${pr.name}"/></h1></a>
        </c:forEach>
    </div>
</div>
<br><br><br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>