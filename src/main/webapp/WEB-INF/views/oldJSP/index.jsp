<%--
  Created by IntelliJ IDEA.
  User: vra
  Date: 25.01.18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookshelf</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<table>
    <caption>CRUD Books v1</caption>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>author</th>
        <th>ISBN</th>
        <th>year</th>
        <th>readALready</th>
    </tr>

</table>

<h1>
    Add a book
</h1>

<c:if test="${!empty listbooks}">
    <table class="tg">
        <tr>
            <th width="80">book ID</th>
            <th width="120">book Title</th>
            <th width="120">book description</th>
            <th width="120">book ISBN</th>
            <th width="120">book Year</th>
            <th width="120">book readAlready</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listbooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>${book.ISBN}</td>
                <td>${book.Year}</td>
                <td>${book.readAlready}</td>
                <td><a href="<c:url value='/edit/${book.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove/${book.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

