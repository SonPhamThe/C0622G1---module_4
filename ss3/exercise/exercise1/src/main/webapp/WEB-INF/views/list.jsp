<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mesohuy999
  Date: 17/10/2022
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>LANGUAGE</th>
        <th>SIZE</th>
        <th>SPAM FILTER</th>
        <th>SIGNATURE</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><b>Language:</b>${mail.language}</td>
    </tr>
    <tr>
        <td><b>Size:</b>${mail.size}</td>
    </tr>
    <tr>
        <td><b>Spam Filter:</b>${mail.spamFilter}</td>
    </tr>
    <tr>
        <td><b>Signature:</b>${mail.signature}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
