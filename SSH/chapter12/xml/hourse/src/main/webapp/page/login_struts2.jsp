<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <title>青鸟租房 - 用户登录</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/style.css"/>
    <script type="text/javascript" src="<%=basePath%>scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="<%=basePath%>images/logo.gif"/></div>
</div>
<div id="regLogin" class="wrap">
    <div class="dialog">
        <div class="box">
            <h4>用户登录</h4>
            <form action="login.action?option=login" method="post">
                <input type="hidden" name="action" value="login"/>
                <div class="infos">
                    <table class="field">

                        <tr>
                            <td colspan="2">${message}<%--<s:fielderror/>--%></td>
                        </tr>
                        <tr>
                            <td class="field">用 户 名：</td>
                            <td><!-- <input type="text" class="text" name="name" /> -->

                                <input type="text" name="name" class="text" id=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="field">密　　码：</td>
                            <td><input type="password" class="text" name="password"/>


                            </td>
                        </tr>
                        <tr>
                            <td class="field">日    期：</td>
                            <td><input type="text" class="text" name="dateStg"/>


                            </td>
                        </tr>
                        <!--
                        <tr>
                            <td class="field">验 证 码：</td>
                            <td><input type="text" class="text verycode" name="veryCode" /></td>
                        </tr>
                        -->
                    </table>
                    <div class="buttons">

                        <input type="submit" value="立即登录">
                        <input type='button' value='注册' onclick='document.location="page/register.jsp"'/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="footer" class="wrap">
    <dl>
        <dt>青鸟租房 &copy; 2010 北大青鸟 京ICP证1000001号</dt>
        <dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
    </dl>
</div>
<script type="text/javascript" src="<%=basePath%>scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
    //非空验证
    $("form").submit(function(){
        if($("[name='name']").val().trim() == "" || $("[name='password']").val().trim() == ""){
            alert('请输入账号或密码!');
            return false;
        }
    });
</script>
</body>
</html>


