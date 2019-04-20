<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>显示用户</title>
</head>
<body>
<table border="1" width="50%">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <%--遍历集合创建标签--%>
    <s:if test="#request.userList != null">
        <s:iterator value="#request.userList" var="user">
            <tr>
                <td>
                    <s:if test="user.name == null">
                        用户名为空
                    </s:if>
                    <s:else>
                        <%--使用标签取值--%>
                        <s:property value="#user.name"/>
                    </s:else>
                </td>
                <td>
                    <s:if test="user.password == null">
                        密码为空
                    </s:if>
                    <s:else>
                        <%--使用EL表达式取值--%>
                        ${user.password}
                    </s:else>
                </td>
            </tr>
        </s:iterator>
    </s:if>
    <s:else>
        暂无数据!
    </s:else>
</table>
</body>
</html>
