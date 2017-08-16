<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Category Settings</title>
</head>
<body>
<h1>Category Settings</h1>
<br>
<table>
    <tr>
        <td>
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>settings</th>
                </tr>
                <tr>
                    <form method="post" action="<c:url value="/root/admin/category/add"/>">
                        <td>
                            <input class="inputTable" title="Category Name" type="text" name="c_id" value="null">
                        </td>
                        <td>
                            <input class="inputTable" title="Category Name" type="text" name="c_name">
                        </td>
                        <td>
                            <input class="inputTable" type="submit" value="add">
                        </td>
                    </form>
                </tr>
                <c:forEach var="cat" items="${categories}">
                    <tr>
                        <td>
                            <c:out value="${cat.id}"/>
                        </td>
                        <td>
                            <c:out value="${cat.name}"/>
                        </td>
                        <td>
                            <a href="
                                <c:url value="/root/admin/category/upd">
                                    <c:param name="c_id" value="${cat.id}" />
                                </c:url>
                            ">edit</a>
                        </td>
                        <td>
                            <a href="
                                <c:url value="/root/admin/category/del">
                                    <c:param name="c_id" value="${cat.id}" />
                                </c:url>
                            ">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
<br>
<a href="<c:url value="/root/profile"/> ">Profile</a>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
