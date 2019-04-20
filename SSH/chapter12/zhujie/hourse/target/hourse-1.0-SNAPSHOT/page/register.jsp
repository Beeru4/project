<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟租房 - 用户注册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
</div>
<div id="regLogin" class="wrap">
	<div class="dialog">
		<dl class="clearfix">
			<dt>新用户注册</dt>
			<dd class="past">填写个人信息</dd>
		</dl>
		<div class="box">
			<form action="registerUser.action?option=register" method="post">
				<div style="color: pink"><s:fielderror/></div>
				<div class="infos">
					<table class="field">
						<tr>
							<td class="field">用 户 名：</td>
							<td><input type="text" class="text" name="name" /> <span id="msg"></span></td>

						</tr>
						<tr>
							<td class="field">密　　码：</td>
							<td><input type="password" class="text" name="password" /></td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input type="password" class="text" name="repassword" /> </td>
						</tr>
						<tr>
							<td class="field">电　　话：</td>
							<td><input type="text" class="text" name="telephone" /> </td>
						</tr>
						<tr>
							<td class="field">用户姓名：</td>
							<td><input type="text" class="text" name="username" /> </td>				
						</tr>
					</table>
					<div class="buttons"><input type="submit" name="submit" value="立即注册" /></div>
				</div>
				<input type="hidden"/>
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
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
    //非空验证
    $("form").submit(function(){
        if($("[name='name']").val().trim() == "" || $("[name='password']").val().trim() == "" || $("[name='telephone']").val().trim() == "" || $("[name='username']").val().trim() == ""){
            alert('请填写完整的注册信息!');
            return false;
        }else if($("[name='password']").val().trim() != $("[name='repassword']").val().trim()){
            alert('两次填写的密码不一致!');
            return false;
		}else if (!/^1[3|4|5|7|8]\d{9}$/.test($("[name='telephone']").val().trim())){
            alert('手机号码有误!');
            return false;
		}
    });
    //验证是否存在
    $("[name='name']").blur(function () {
        var $name = $(this);
		$.getJSON("checkNameUser",{name:$(this).val()},function (data) {
			if(data.code == 10001){
               $("#msg").html(data.message);
			}
        })
    });
</script>
</body>
</html>

