<%--
  Created by IntelliJ IDEA.
  User: shil
  Date: 2018/7/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user login</title>
</head>
<body>
    <form action="/student/login" method="post">
        <h1>用户登陆</h1><br>
        <label>id:</label><input type="text" name="id"><br>
        <label>name:</label><input type="text" name="name"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
