<%--
  Created by IntelliJ IDEA.
  User: J.z
  Date: 2019-05-09
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用JSON解决乱码</title>
</head>
<body>
<table width="50%" border="1">
    <tr>
        <td>输入后的姓名</td>
        <td>输入后的年龄</td>
        <td>输入后的日期</td>
    </tr>
    <tr>
        <td id="oldName"></td>
        <td id="oldAge"></td>
        <td id="oldBirthday"></td>
    </tr>
</table>
<form method="POST" action="${pageContext.request.contextPath}/date">
    <span style="color: red">${requestScope.error}</span><br>
    输入姓名:<input type="text" name="userName"><br>
    输入年龄:<input type="text" name="age"><br>
    输入日期:<input type="text" name="birthday"><br><span id="error" style="color: orange"></span>
    <input type="button" value="异步提交">
    <input type="submit" value="提交">
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
<script>
    $("[type=button]").click(function () {
        if (null != $(this).val()) {
            //使用ajax请求服务器
            $.ajax({
                type: "GET",
                url: "${pageContext.request.contextPath}/json",
                dataType: "JSON",
                success: function (result) {
                    if (null != result.userName) {
                        $("#oldName").text(result.userName);
                    }
                    if (null != result.age) {
                        $("#oldAge").text(result.age);
                    }
                    if (null != result.birthday) {
                        $("#oldBirthday").text(result.birthday);
                    }
                },
                error: function (error) {
                    $("error").text("抱歉,请求服务失败.");
                }
            })
        }

    });
    /*$("[type=button]").click(function () {
        if (null != $(this).val()) {
                //使用ajax请求服务器
                $.ajax({
                    type: "GET",
                    url: "/json",
                    data: {data: $("[name=birthday]").val()},
                    dataType: "JSON",
                    success: function (result) {

                    },
                    error: function (error) {
                        $("error").text("抱歉,请求服务失败.");
                    }
                })
        }

    });*/

</script>
</body>
</html>
