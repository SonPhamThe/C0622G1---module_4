<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Dictionary App</h1>
<form action="/dictionary/search" >
    <input type="text" name="word" value="${word}" placeholder="...search word">
    <input type="submit" value="Search">
</form>
<p>Mean : ${mean}</p>
</body>
</html>