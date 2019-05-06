<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019-05-05
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>提交页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/submit" method="get">
  请输入userCode: <input type="text" name="userCode"/>
  <br>
  <input type="submit">
</form>
</body>
</html>
