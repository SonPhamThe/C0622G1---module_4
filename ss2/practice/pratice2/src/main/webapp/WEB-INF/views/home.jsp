<%--
  Created by IntelliJ IDEA.
  User: mesohuy999
  Date: 14/10/2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="validate" method="post">
    <h3 style="color: red">${message}</h3>
    <input type="text" name="email" placeholder="Enter email">
    <input type="submit" value="Validate">
</form>
</body>
</html>
