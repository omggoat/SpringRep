<%--
  Created by IntelliJ IDEA.
  User: shil
  Date: 2018/7/25
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
      error page,
      <%
          String error_type = (String)request.getAttribute("exception_type");
         if(null!=error_type){
       %>
         the error type is:<%=error_type%>
       <%
           }
       %>

</body>
</html>
