<%--
  Created by IntelliJ IDEA.
  User: khoabug
  Date: 7/21/23
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<table>
        <c:forEach var="item" items="${requestScope.model}">
            <tr>
                <td>${item.id}</td>
                <td>${item.email}</td>
            </tr>
        </c:forEach>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button id="log-btn" type="submit">Log Out</button>
    </form>
</table>

</body>
</html>
