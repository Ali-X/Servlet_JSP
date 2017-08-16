<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="pr" value="${product}"/>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title><c:out value="${pr.name}"/></title>
</head>
<body>
<h1><c:out value="${pr.name}"/>:</h1>
<br>
<h2>Name:</h2>
<h4><c:out value="${pr.name}"/></h4>
<h2>Description:</h2>
<h4><c:out value="${pr.description}"/></h4>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>