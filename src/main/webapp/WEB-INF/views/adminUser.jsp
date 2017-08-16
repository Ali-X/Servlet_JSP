<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <jsp:directive.include file="/css/style.css" />
    </style>
    <title>User settings</title>
</head>
<body>
<h1>User settings</h1>
<br>
<table>
    <tr>
        <td>
            <h3>Users</h3>
            <table>
                <tr>
                    <th>id</th>
                    <th>username</th>
                    <th>password</th>
                    <th>email</th>
                    <th>settings</th>
                </tr>
                <c:forEach var="u" items="${users}">
                    <tr>
                        <td>
                            <c:out value="${u.id}"/>
                        </td>
                        <td>
                            <c:out value="${u.userName}"/>
                        </td>
                        <td>
                            <c:out value="${u.password}"/>
                        </td>
                        <td>
                            <c:out value="${u.email}"/>
                        </td>
                        <td>
                            <a href="
                                <c:url value="/root/admin/user/del">
                                    <c:param name="u_id" value="${u.id}" />
                                </c:url>
                            ">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <h3>Roles</h3>
            <table>
                <tr>
                    <th>username</th>
                    <th>role</th>
                    <th>settings</th>
                </tr>
                <tr>
                    <form method="post" action="<c:url value="/root/admin/user/role/add"/>">
                        <td>
                            <select class="inputTable" name="u_id">
                                <c:forEach var="u" items="${users}">
                                    <option value="${u.id}">${u.userName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select class="inputTable" name="u_role">
                                <c:forEach var="r" items="${allRoles}">
                                    <option value="${r}">${r}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input class="inputTable" type="submit" value="add">
                        </td>
                    </form>
                </tr>
                <c:forEach var="users" items="${userWithRoles}">
                    <tr>
                        <td>
                            <c:out value="${users.userName}"/>
                        </td>
                        <td>
                            <c:forEach var="r" items="${users.roles}">
                                <c:out value="${r}"/>
                        <td>
                            <a href="
                                        <c:url value="/root/admin/user/role/del">
                                            <c:param name="u_id" value="${users.id}" />
                                            <c:param name="ur_name" value="${r}" />
                                        </c:url>
                                    ">delete</a>
                        </td>
                        </c:forEach>
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
