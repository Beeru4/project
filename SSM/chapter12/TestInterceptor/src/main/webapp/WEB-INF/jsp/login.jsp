<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019-05-10
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dologin" method="post">
    用户名:<input type="text" name="userName">
    <input type="submit" value="登入">
</form>
<div style="color: red">${requestScope.error}</div>
</body>
</html>
