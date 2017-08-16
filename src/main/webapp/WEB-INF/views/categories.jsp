<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Welcome</title>
</head>
<body>
<h1>Hello, ${requestScope.user.userName}</h1>
<br>
<h4>Choose category:</h4>
<div class="dropdown">
    <button class="dropbtn">Category</button>
    <div class="dropdown-content">
        <c:forEach var="cat" items="${categories}">
            <a class="menu" href="
                                <c:url value="/root/category">
                                    <c:param name="c_id" value="${cat.id}" />
                                </c:url>
                            "><c:out value="${cat.name}"/></h1></a>
        </c:forEach>
    </div>
</div>
<br><br><br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>

