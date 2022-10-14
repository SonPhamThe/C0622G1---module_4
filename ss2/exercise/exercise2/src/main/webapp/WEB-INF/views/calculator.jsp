<%--
  Created by IntelliJ IDEA.
  User: mesohuy999
  Date: 14/10/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="cal" method="post">
    <input value="${a}" type="number" name="a" placeholder="Input a in here">
    <input value="${b}" type="number" name="b" placeholder="Input b in here">

    <input type="submit" name="submit" value="Addition(+)">
    <input type="submit" name="submit" value="Subtraction(-)">
    <input type="submit" name="submit" value="Multiplication(*)">
    <input type="submit" name="submit" value="Division(/)">
    <p>Result: ${result}</p>
</form>
</body>
</html>
