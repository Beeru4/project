<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>青鸟租房 -发布房屋信息</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif"/></div>

</div>
<div id="regLogin" class="wrap">
    <div class="dialog">
        <dl class="clearfix">
            <dt>新房屋信息发布</dt>
            <dd class="past">填写房屋信息</dd>

        </dl>
        <div class="box">
            <form action="addHouse.action">
                <div class="infos">
                    <table class="field">
                        <tr>
                            <td class="field">标　　题：</td>
                            <td>
                                <input cssClass="text" key="title" name="params.title"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="field">户　　型：</td>
                            <td><select class="text" name="params.type.id">
                                <option value="2201">1室1厅</option>
                                <option value="2202">1房0厅1卫</option>
                                <option value="2203">2房0厅1卫</option>
                                <option value="2204">2房1厅1卫</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td class="field">面　　积：</td>
                            <td><input cssClass="text" key="floorage" name="params.floorage"/></td>
                        </tr>
                        <tr>
                            <td class="field">价　　格：</td>
                            <td>
                                <input cssClass="text" key="price" name="params.price"/>
                            </td>
                        </tr>

                        <%--<tr>
                            <td class="field">房产证日期：</td>
                            <td><input cssClass="text" key="houseDate" name="houseDate"/></td>
                        </tr>--%>

                        <tr>
                            <td class="field">位　　置：</td>
                            <td>
                                区：<select class="text" name="params.street.district.id">
                                <option value="3301">福田区</option>
                            </select>
                                街：<select class="text" name="params.street.id">
                                <option value="4401">华强北街道</option>
                                <option value="4402">深南中路</option>
                                <option value="4403">福田街道</option>
                            </select>

                            </td>
                        </tr>
                        <tr>
                            <td class="field">联系方式：</td>
                            <td>
                                <input cssClass="text" key="contact" name="params.contact"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="field">详细信息：</td>
                            <td><textarea name="params.description"></textarea></td>
                        </tr>
                    </table>
                    <div class="buttons">
                        <s:submit value="立即发布"/>
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

</body>
</html>