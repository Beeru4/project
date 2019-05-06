<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019-05-05
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>显示详细详细</title>
</head>
<body>
<table width="100%" border="1">
    <tr style="background-color: #ccc">
        <th>型号</th>
        <th>出场价格(元)</th>
        <th>出厂日期</th>
    </tr>
    <c:if test="${null != descList}">
        <c:forEach items="${requestScope.descList}" var="desc" varStatus="status">
            <tr <c:if test="${status.index % 2 == 0}"> style="background-color: orange"</c:if> >
                <td>${desc.type}</td>
                <td>${desc.price}</td>
                <td><fmt:formatDate value="${desc.date}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
