<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: maksf
  Date: 14.03.2019
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Map</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table>
        <c:forEach items="${resultView}" var="entry">
           User ID:  ${entry.key}<br>
            ${entry.value}<br>
        </c:forEach>
    </table>
</body>
</html>
