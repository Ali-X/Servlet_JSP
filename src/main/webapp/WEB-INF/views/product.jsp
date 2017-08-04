<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var = "pr" value = "${product}"/>
<html>
<head>
    <title><c:out value="${pr.name}"/></title>
</head>
<body>

<table>

    <tr>
        <th>
            <h1><c:out value="${pr.name}"/>:</h1>
        </th>
    </tr>

    <tr>
        <th>
            <h2>Name:</h2>
            <h4><c:out value="${pr.name}"/></h4>
            <h2>Description:</h2>
            <h4><c:out value="${pr.description}"/></h4>
        </th>
    </tr>
</table>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>