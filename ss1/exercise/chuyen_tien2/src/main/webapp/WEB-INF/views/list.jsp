<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
</head>
<body>
<h2>Converting Money</h2>
<form action="/result">
    <input type="number" name="usd" value="${usd}" placeholder="Input money to want convert">
    <input type="submit" value="Convert">
    <p>USD: ${usd}</p>
    <p>VND: ${vnd}</p>
</form>
</body>
</html>