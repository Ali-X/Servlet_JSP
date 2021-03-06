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
<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a class="pagination" href="
            <c:url value="/root/admin/product">
                 <c:param name="page" value="${currentPage - 1}" />
            </c:url>
        ">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<c:forEach begin="1" end="${noOfPages}" var="i">
    <c:choose>
        <c:when test="${currentPage eq i}">
            <td>${i}</td>
        </c:when>
        <c:otherwise>
            <td><a class="pagination" href="
                            <c:url value="/root/admin/product">
                                <c:param name="page" value="${i}" />
                            </c:url>
                        ">${i}</a></td>
        </c:otherwise>
    </c:choose>
</c:forEach>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a class="pagination" href="
            <c:url value="/root/admin/product">
                 <c:param name="page" value="${currentPage + 1}" />
            </c:url>
        ">Next</a></td>
</c:if>
<br><br>
<a href="<c:url value="/root/profile"/> ">Profile</a>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
