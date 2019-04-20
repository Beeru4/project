<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019/4/9
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>多个文件上传</title>
</head>
<body>
<form action="many.action"  method="post" enctype="multipart/form-data">
    <input type="file" name="img_file"/>
    <input type="file" name="img_file"/>
    <input type="file" name="img_file"/>
    <input type="submit"/>
</form>
<s:actionerror/>
<s:fielderror/>
<s:iterator value="img_fileFileName">
    <img  src="<s:property value="savePath"/>/<s:property/>">
</s:iterator>
</body>
</html>
