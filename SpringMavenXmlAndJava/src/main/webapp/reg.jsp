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
    <title>user reg</title>
</head>
<body>
    <form action="/student/reg" method="POST" enctype="multipart/form-data">
        <h1>用户注册</h1><br>
        <label>id:</label><input type="text" name="id"/><br>
        <label>name:</label><input type="text" name="name"/><br>
        <label>age:</label><input type="text" name="age"/><br>
        <label>myphoto:</label><input type="file" name="myphoto"/><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
