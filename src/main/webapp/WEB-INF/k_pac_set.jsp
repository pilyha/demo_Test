<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>K_PAC_set</title>
    <link rel="stylesheet" type="text/css" href="/css/dhtmlx.css">
    <script src="/js/dhtmlx.js"></script>
</head>
<body>
<H3>K_PAC_set</H3>

<table id="k_pac_set">
    <thead>
    <tr>
        <th >ID</th>
        <th>Title</th>
        <th width="400">K_PACs</th>
    </tr>
    </thead>
    <tbody>
    <td><c:out value="${kpac_set.id}"> </c:out></td>
    <td><c:out value="${kpac_set.title}"> </c:out></td>
    <td>
        <table id="k_pac">
            <c:forEach items="${kpac_set.k_pacs}" var="kpac">
                <tr>
                    <td width="80" type="ro" sort="int">${ kpac.id}</td>
                    <td width="150" type="ro" sort="string">${ kpac.title}</td>
                    <td width="100"><form:form action="/kpacs/${kpac.id}" method="DELETE">
                        <input type="submit" value="Delete"/>
                    </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </td>
    </tbody>
</table>
<script>
    mygrid = new dhtmlXGridFromTable('k_pac_set');
    mygrid.attachHeader("#numeric_filter,#text_filter,");
    mygrid.setColTypes("ro,ro,ro");
    mygrid.setColSorting("int,str,na");
    myinnergrid = new dhtmlXGridFromTable('k_pac');
    myinnergrid.attachHeader("#numeric_filter,#text_filter,");
    myinnergrid.setColTypes("ro,ro,ro");
    myinnergrid.setColSorting("int,str,na");

</script>
</body>
</html>
