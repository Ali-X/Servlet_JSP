<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            text-align: center;
            width: 80%;
        }

        td, th {
            border: 1px solid #dddddd;
            vertical-align: text-top;
            padding: 8px;
        }

        h2 {
            color: red;
        }

    </style>
    <title>Admin Protected Page</title>
</head>
<body>
<h1>Admin Protected Page</h1>
Hello ${requestScope.user.userName}!
<br>
<table>
    <tr>
        <th><h2>Category control</h2></th>
        <th><h2>Product control</h2></th>
    </tr>

    <tr>
        <td><h3>Add new category</h3>
            <form method="post" action="<c:url value="/root/c_add"/>">
                Category Name:<br>
                <input title="Category Name" type="text" name="c_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>

        <td>
            <h3>Add new product</h3>
            <form method="post" action="<c:url value="/root/p_add"/>">
                Product Name:<br>
                <input title="Product Name" type="text" name="p_name">
                <br><br>
                Product description:<br>
                <input title="Product description" type="text" name="p_descr">
                <br><br>
                Category Name:<br>
                <input title="Category Name" type="text" name="c_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>
    </tr>

    <tr>
        <td>
            <h3>Delete category</h3>
            <form method="post" action="<c:url value="/root/c_del"/>">
                Category Name:<br>
                <input title="Category Name" type="text" name="c_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>

        <td>
            <h3>Delete product</h3>
            <form method="post" action="<c:url value="/root/p_del"/>">
                Product Name:<br>
                <input title="Product Name" type="text" name="p_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>
    </tr>

    <tr>
        <td>
            <h3>Update category</h3>
            <form method="post" action="<c:url value="/root/c_upd"/>">
                Old Category Name:<br>
                <input title="Old Category Name" type="text" name="old_c_name">
                <br><br>
                New Category Name:<br>
                <input title="New Category Name" type="text" name="new_c_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>

        <td>
            <h3>Update product</h3>
            <form method="post" action="<c:url value="/root/p_upd"/>">
                Old Product Name:<br>
                <input title="Old Category Name" type="text" name="old_p_name">
                <br><br>
                New Product Name:<br>
                <input title="New Category Name" type="text" name="new_p_name">
                <br><br>
                Product description:<br>
                <input title="Product description" type="text" name="p_descr">
                <br><br>
                Category Name:<br>
                <input title="Category Name" type="text" name="c_name">
                <br><br>
                <input type="submit" value="Submit">
            </form>
        </td>
    </tr>
</table>
<br>
<a href="<c:url value="/root/home"/> ">Home</a>
</body>
</html>
