<%--
  Created by IntelliJ IDEA.
  User: DarthVader
  Date: 26.11.2016
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request User</title>
</head>
<body>
<h1>Hello ${name}</h1>

<form action="/result" method="GET">
    <p>Name:
        <input type="text" name="name"></p>

    <p>Id:
        <input type="number" name="id"></p>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
