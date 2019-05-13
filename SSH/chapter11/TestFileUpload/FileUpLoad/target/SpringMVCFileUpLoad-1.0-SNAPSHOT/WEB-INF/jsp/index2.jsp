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
    <title>上传文件</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploads" method="post" enctype="multipart/form-data">
    <input type="file" name="imgs"><br>
    <input type="file" name="imgs"><br>
    <input type="submit" value="提交文件">
</form>
<div>
    ${exception.message}
</div>
</body>
</html>
