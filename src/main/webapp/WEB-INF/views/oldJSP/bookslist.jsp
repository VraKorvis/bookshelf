<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All books</title>
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
<h1>
    Add a book
</h1>
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

<%--<div id="pagination">--%>

    <%--<c:url value="/user/list" var="prev">--%>
        <%--<c:param name="page" value="${page-1}"/>--%>
    <%--</c:url>--%>
    <%--<c:if test="${page > 1}">--%>
        <%--<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>--%>
    <%--</c:if>--%>

    <%--<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">--%>
        <%--<c:choose>--%>
            <%--<c:when test="${page == i.index}">--%>
                <%--<span>${i.index}</span>--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<c:url value="/user/list" var="url">--%>
                    <%--<c:param name="page" value="${i.index}"/>--%>
                <%--</c:url>--%>
                <%--<a href='<c:out value="${url}" />'>${i.index}</a>--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    <%--</c:forEach>--%>
    <%--<c:url value="/user/list" var="next">--%>
        <%--<c:param name="page" value="${page + 1}"/>--%>
    <%--</c:url>--%>
    <%--<c:if test="${page + 1 <= maxPages}">--%>
        <%--<a href='<c:out value="${next}" />' class="pn next">Next</a>--%>
    <%--</c:if>--%>
<%--</div>--%>
<%--@RequestMapping(value="/list")--%>
<%--public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {--%>
<%--ModelAndView modelAndView = new ModelAndView("list-of-users");--%>

<%--List<User> users = userService.getUsers();--%>
    <%--PagedListHolder<User> pagedListHolder = new PagedListHolder<>(users);--%>
        <%--pagedListHolder.setPageSize(5);--%>
        <%--modelAndView.addObject("maxPages", pagedListHolder.getPageCount());--%>

        <%--if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;--%>

        <%--modelAndView.addObject("page", page);--%>
        <%--if(page == null || page < 1 || page > pagedListHolder.getPageCount()){--%>
        <%--pagedListHolder.setPage(0);--%>
        <%--modelAndView.addObject("users", pagedListHolder.getPageList());--%>
        <%--}--%>
        <%--else if(page <= pagedListHolder.getPageCount()) {--%>
        <%--pagedListHolder.setPage(page-1);--%>
        <%--modelAndView.addObject("users", pagedListHolder.getPageList());--%>
        <%--}--%>

        <%--return modelAndView;--%>
        <%--}--%>
</body>
</html>