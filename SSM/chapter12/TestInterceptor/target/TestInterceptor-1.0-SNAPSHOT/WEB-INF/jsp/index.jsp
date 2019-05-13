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
    <title>首页</title>
</head>
<body>
<div style="color: orange">欢迎您:${sessionScope.user.userName}</div>
<a href="${pageContext.request.contextPath}/sys/user/logout">退出</a>
</body>
</html>
