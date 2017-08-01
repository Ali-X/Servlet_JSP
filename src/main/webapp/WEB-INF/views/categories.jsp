<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        .dropbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }
    </style>
    <title>Welcome</title>
</head>
<body>

<table>

    <tr>
        <th>
            <h1>Hello, ${requestScope.user.userName}</h1>
        </th>
    </tr>

    <tr>
        <th>
            <p>Choose category:</p>
            <div class="dropdown">
                <button class="dropbtn">Category</button>
                <div class="dropdown-content">
                        <c:forEach var="cat" items="${categories}">
                            <a href="
                                <c:url value="/category">
                                    <c:param name="c_id" value="${cat.id}" />
                                </c:url>
                            "><c:out value="${cat.name}"/></h1></a>
                        </c:forEach>

                </div>
            </div>
        </th>
    </tr>
</table>
</body>
</html>

