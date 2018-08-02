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
    <title>success</title>
</head>
<body>
<%
    if(request.getAttribute("studentname")!=null){
        String name=(String)request.getAttribute("studentname");
%>
hi,<%=name%>
<%
    }else if(request.getAttribute("studentage")!=null){
    String age = (String)request.getAttribute("studentage");
%>
hi,the student age is:<%=age%>
<%
    }
%>
</body>
</html>
