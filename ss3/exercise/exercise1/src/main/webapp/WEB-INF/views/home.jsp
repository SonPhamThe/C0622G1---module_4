<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mesohuy999
  Date: 17/10/2022
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Box</title>
</head>
<body>
<form:form action="/home" method="post" modelAttribute="mail" cssStyle="width: 30%">
    <fieldset>
        <legend><b style="color:darkgreen;">Form Mail Box</b></legend>
        <form:label path="language"><b>Languages: </b></form:label>
        <form:select size="1" path="language" items="${languageList}">
        </form:select>

        <br> <br>

        <form:label path="size"><b>Page Size: </b> Show </form:label>
        <form:select size="1" path="size">
            <form:options items="${sizeList}"/>
        </form:select> emails per page

        <br> <br>
        <form:label path="spamFilter"><b>Spam Filter: </b> </form:label>
        <form:checkbox value="Enable spams filter" path="spamFilter"/> Enable spams filter

        <br> <br>

        <form:label path="signature"><b>Signature: </b> </form:label>
        <form:textarea path="signature"/>
m
        <br> <br>

        <button type="submit">Update</button>
        <button type="reset">Cancel</button>
    </fieldset>
</form:form>
</body>
</html>
