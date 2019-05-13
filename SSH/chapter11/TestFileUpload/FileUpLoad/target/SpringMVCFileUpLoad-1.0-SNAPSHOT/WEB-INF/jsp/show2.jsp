<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019-05-08
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示上传的文件</title>
</head>
<body>
<img src="${pageContext.request.contextPath }/statics/images/${fileName0}">
<img src="${pageContext.request.contextPath }/statics/images/${fileName1}">
<div style="color: orange">
    <span>${requestScope.error}</span>
    <span> ${requestScope.noFileUpload}</span>
</div>
</body>
</html>
