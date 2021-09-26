<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>K_PACs</title>
    <%--    <link rel="stylesheet" type="text/css" href="/css/grid.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/dhtmlx.css">
    <%--    <script src="/js/grid.js"></script>--%>
    <script src="/js/dhtmlx.js"></script>
</head>
<body>
<H3>K_PACs</H3>
<%--<div id="grid_container"></div>--%>
<%--<script>--%>
<%--    const grid = new dhx.Grid("grid", {--%>
<%--        columns: [--%>
<%--            { width: 80, id: "id", header: [{ text: "ID" }] },--%>
<%--            { width: 80, id: "title", header: [{ text: "Title" }] },--%>
<%--            { width: 150, id: "description", header: [{ text: "Description" }] },--%>
<%--            { width: 200, id: "created_at", header: [{ text: "Created_at" }] },--%>
<%--            {--%>
<%--                id: "action", gravity: 1.5, header: [{ text: "Action", align: "center" }],--%>
<%--                htmlEnable: true, align: "center",--%>
<%--                template: function () {--%>
<%--                    return "<span class='action-buttons'><a class='remove-button'>Delete</a></span>"--%>
<%--                }--%>
<%--            }--%>
<%--        ],--%>
<%--        eventHandlers: {--%>
<%--            onclick: {--%>
<%--                "remove-button": function (e, data) {--%>
<%--                    grid.data.remove(data.row.id);--%>
<%--                }--%>
<%--            }--%>
<%--        }--%>
<%--    });--%>
<%--    <c:forEach items="${kpacs}" var="kpac">--%>
<%--    grid.data.add({--%>
<%--        "id":"${ kpac.id }",--%>
<%--        "title":"${ kpac.title }",--%>
<%--        "description":"${ kpac.description }",--%>
<%--        "created_at":"${ kpac.createdAt }"--%>

<%--    });--%>
<%--    </c:forEach>--%>

<%--</script>--%>

<table id="k_pacs">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>CreatedAt</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${kpacs}" var="kpac">
        <td>${ kpac.id }</td>
        <td>${ kpac.title}</td>
        <td>${ kpac.description}</td>
        <td>${ kpac.createdAt}</td>
        <td><form:form action="/kpacs/${kpac.id}" method="DELETE">
            <input type="submit" value="Delete"/>
        </form:form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    mygrid = new dhtmlXGridFromTable('k_pacs');
    mygrid.attachHeader("#numeric_filter,#text_filter,#text_filter,#select_filter,");
    mygrid.setColTypes("ro,ro,ro,ro,ro");
    mygrid.setColSorting("int,str,str,date,na");
</script>
<form:form action="/kpacs/new" method="POST" modelAttribute="kpac">
    <h4>Add new K_PAC</h4>
    <p>
        <form:label path="title">title</form:label>
        <form:input type="text" path="title" class="input"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:input type="text" path="description" class="input"/>
    </p>
    <p>
        <form:label path="kPacSet">kPacSet</form:label>
        <form:select path="kPacSet">
            <c:forEach items="${ kpac_set }" var="kpac">
                <option value="${ kpac.id }">${ kpac.title }</option>
            </c:forEach>
        </form:select>
    </p>
    <input type="submit" value="Add"/>
</form:form>

</body>
</html>