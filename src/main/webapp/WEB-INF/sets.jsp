<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>K_PAC_sets</title>
    <%--    <link rel="stylesheet" type="text/css" href="/css/grid.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/dhtmlx.css">
    <%--    <script src="/js/grid.js"></script>--%>
    <script src="/js/dhtmlx.js"></script>
</head>
<body>
<H3>K_PAC_sets</H3>
<table id="k_pac_sets">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${kpac_sets}" var="kpac_set">
        <td><a href="/kpac-sets/${ kpac_set.id }">${ kpac_set.id }</a></td>
        <td>${ kpac_set.title}</td>
        <td><form:form action="/kpac-sets/${kpac_set.id}" method="DELETE">
            <input type="submit" value="Delete"/>
        </form:form>
        </td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<script>
    mygrid = new dhtmlXGridFromTable('k_pac_sets');
    mygrid.attachHeader("#numeric_filter,#text_filter,");
    mygrid.setColTypes("ro,ro,ro");
    mygrid.setColSorting("int,str,na");
</script>
<form:form action="/kpac-sets/new" method="POST" modelAttribute="kpac_set">
    <h4>Add new K_PAC_set</h4>
    <p>
        <form:label path="title">title</form:label>
        <form:input type="text" path="title" class="input"/>
    </p>
    <input type="submit" value="Add"/>
</form:form>

</body>
</html>
