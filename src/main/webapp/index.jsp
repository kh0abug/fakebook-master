<%--
  Created by IntelliJ IDEA.
  User: khoabug
  Date: 7/21/23
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input name="email" type="text" placeholder="Email address">
    <input name="password" type="password" placeholder="Password">

    <button id="log-btn" type="submit">Log In</button>
</form>
</body>
</html>
