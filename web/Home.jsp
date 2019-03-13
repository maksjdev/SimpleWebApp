<%--
  Created by IntelliJ IDEA.
  User: maksf
  Date: 13.03.2019
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second Page</title>
</head>
<body>
<center>
    <h1>
        Hello <%=request.getParameter("username")%>
    </h1>
    <h1>Get Inormation about user:</h1>
    <br>
    <form name="form" action="LoginServlet" method="get">
        <table align="center">
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username"  /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Find"></input><input
                        type="reset" value="Reset"></input></td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
