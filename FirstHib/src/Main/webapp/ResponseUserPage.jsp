<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DarthVader
  Date: 26.11.2016
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response User</title>
</head>
<body>
<h1>${user.person}</h1>
<h1>${user.age}</h1>
<h1>${wrongName}</h1>
<h1><table>
    <c:forEach items="${user.eventPOList}" var="event">
        <tr>
            <td><c:out value="${event}" /></td>

        </tr>
    </c:forEach>
</table></h1>
</body>
</html>
