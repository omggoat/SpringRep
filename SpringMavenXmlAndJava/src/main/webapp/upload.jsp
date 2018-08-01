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
    <title>upload</title>
</head>
<body>
    <form action="/upload/multpartFile" method="POST" enctype="multipart/form-data">
        <label>myphoto:</label><input type="file" name="multipartFile" accept="image/jpeg,image/png,image/gif"/><br>
        <input type="submit" value="submit-multpartFile">
    </form>
    <form action="/upload/byteArray" method="POST" enctype="multipart/form-data">
        <label>myphoto:</label><input type="file" name="byteArray" accept="image/jpeg,image/png,image/gif"/><br>
        <input type="submit" value="submit-byteArray">
    </form>
    <form action="/upload/part" method="POST" enctype="multipart/form-data">
        <label>myphoto:</label><input type="file" name="part" accept="image/jpeg,image/png,image/gif"/><br>
        <input type="submit" value="submit-part">
    </form>
</body>
</html>
