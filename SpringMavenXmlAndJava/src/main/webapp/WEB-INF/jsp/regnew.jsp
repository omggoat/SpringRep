<%--
  Created by IntelliJ IDEA.
  User: shil
  Date: 2018/7/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>user reg</title>
    <style type="text/css">
        .a {color: red}
    </style>

</head>
<body>
    <sf:form method="POST" commandName="student">
        <sf:errors path="*" cssClass="a"/><br>
        <h1>用户注册</h1><br>
        id:<sf:input path="id"/><br>
        name:<sf:input path="name"/><br>
        age:<sf:input path="age"/><br>
        <input type="submit" value="submit">
    </sf:form>
</body>
</html>
