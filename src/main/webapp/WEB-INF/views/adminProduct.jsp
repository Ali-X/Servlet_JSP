<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>Product Settings</title>
</head>
<body>
<h1>Product Settings</h1>
<br>
<table>
    <tr>
        <td>
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>description</th>
                    <th>category name</th>
                    <th>settings</th>
                </tr>
                <tr>
                    <form method="post" action="<c:url value="/root/admin/product/add"/>">
                        <td>
                            <input class="inputTable" title="Product Name" type="text" name="p_id" value="null">
                        </td>
                        <td>
                            <input class="inputTable" title="Product Name" type="text" name="p_name">
                        </td>
                        <td>
                            <input class="inputTable" title="Product description" type="text" name="p_descr">
                        </td>
                        <td>
                            <select class="inputTable" name="c_id">
                                <c:forEach var="cat" items="${categories}">
                                    <option value="${cat.id}">${cat.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input class="inputTable" type="submit" value="add">
                        </td>
                    </form>
                </tr>
                <c:forEach var="pr" items="${products}">
                    <tr>
                        <td>
                            <c:out value="${pr.id}"/>
                        </td>
                        <td>
                            <c:out value="${pr.name}"/>
                        </td>
                        <td>
                            <c:out value="${pr.description}"/>
                        </td>
                        <td>
                            <c:out value="${pr.category.name}"/>
                        </td>
                        <td>
                            <a href="
                                <c:url value="/root/admin/product/upd">
                                    <c:param name="p_id" value="${pr.id}" />
                                </c:url>
                            ">edit</a>
                        </td>
                        <td>
                            <a href="
                                <c:url value="/root/admin/product/del">
                                    <c:param name="p_id" value="${pr.id}" />
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
