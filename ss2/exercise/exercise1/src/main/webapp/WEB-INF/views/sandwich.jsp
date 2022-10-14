<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mesohuy999
  Date: 14/10/2022
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
    <input type="checkbox" value="Lettuce" name="condiment"> Lettuce
    <input type="checkbox" value="Tomato" name="condiment"> Tomato
    <input type="checkbox" value="Mustard" name="condiment"> Mustard
    <input type="checkbox" value="Sprouts" name="condiment"> Sprouts
    <button type="submit" value="Save">Save</button>
    <p>Result: <c:forEach items="${condiment}" var="condiment">
        ${condiment}
    </c:forEach>
    </p>
</form>
</body>
</html>
