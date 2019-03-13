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
    <title>Start Page</title>
</head>
<body>
<div style="text-align:center"><h1>Hello User </h1> </div>
<div style="text-align:center"><h1>Enter your information please </h1> </div>
<br>
<form name="form" action="LoginServlet" method="post">
    <table align="center">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username"  /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" /></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input type="tel" name="phone_number" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"></input><input
                    type="reset" value="Reset"></input></td>
        </tr>
    </table>
</form>
</body>
</html>
