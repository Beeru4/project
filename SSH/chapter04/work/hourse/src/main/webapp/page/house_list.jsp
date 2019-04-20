<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>青鸟租房 - 首页</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="scripts/function.js"></script>
	<script type="text/javascript">
		function toUrl(url){
			window.location.href = url;
			return;
		}
		
		function doSearch(){
			var f = document.getElementById('sform');
			f.submit();
		}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
</div>
<div id="navbar" class="wrap">

	<dl class="search clearfix">
		<form method="post" action="findByConditionList.action" id='sform'>
			<dt>
				<ul>
					<li class="bold">房屋信息</li>
					<li>
						标题：<input type="text" class="text" value='<s:property value="params.title"/>' name="params.title" />
						<label class="ui-blue"><input type="button" onclick='doSearch()' name="search" value="搜索房屋" /></label>
					</li>
				</ul>
			</dt>
			<dd>
				<ul>
					<li class="first">
						价格
					</li>

					<li>
						<select name='params.price'>
							<option value='0' <s:if test="params.price == 0">selected="selected"</s:if>>不限</option>
							<option value='100' <s:if test="params.price == 100">selected="selected"</s:if>>100元以下</option>
							<option value='200' <s:if test="params.price == 200">selected="selected"</s:if>>100元—200元</option>
							<option value='201' <s:if test="params.price == 201">selected="selected"</s:if>>200元以上</option>
						</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房屋位置</li>
					<li>
							<select name='params.postion' id='street'>
								<option value='0' <s:if test="params.price == 0">selected="selected"</s:if>>不限</option>
								<option value='4401' <s:if test="params.postion == 4401">selected="selected"</s:if>>华强北街道</option>
								<option value='4402' <s:if test="params.postion == 4402">selected="selected"</s:if>>深南中路</option>
								<option value='4403' <s:if test="params.postion == 4403">selected="selected"</s:if>>福田街道</option>
								<option value='4404' <s:if test="params.postion == 4404">selected="selected"</s:if>>沿河南路</option>
							</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">房型</li>
					<li>
							<select name='params.type.id'>
								<option value='0'>不限</option>
                                <s:if test="typeList!=null">
                                    <s:iterator value="typeList">
                                        <option value='<s:property value="id"/>'><s:property value="name"/></option>
                                    </s:iterator>
                                </s:if>
							</select>
					</li>
				</ul>
			</dd>
			<dd>
				<ul>
					<li class="first">
						面积
					</li>
					<li>
							<select name='params.floorage'>
								<option value='0'>不限</option>
								<option value='40'>40以下</option>
								<option value='500'>40-500</option>
								<option value='501'>500以上</option>
							</select>
					</li>
				</ul>
			</dd>
		</form>
	</dl>
</div>
<div class="main wrap">
	<table class="house-list">
	<s:if test="page.pages!=null">
	<s:iterator value="page.pages" status="status" >
		<tr>
			<td class="house-thumb"><span>
				<s:url value="showHouse.action" id="show">
					<s:param name="id" value="id"></s:param>
				</s:url>
				<s:a href="%{show}"><img src="images/thumb_house.gif" /></s:a>
			</span>	</td>
			<td>
				<dl>
					<dt><s:property value="title"/></dt>
					<dd>
						<s:property value="street.district.name"/>区
						<s:property value="street.name"/>，
						<s:property value="floorage"/>平米<br/>
						联系方式<s:property value="contact"/>
					</dd>
				</dl>
			</td>
			<td class="house-type"><s:property value="type.name"/></td>
			<td class="house-price"><span><s:property value="price"/></span>元/月</td>
		</tr>
	</s:iterator>
	</s:if>   

	</table>
	<div class="pager">
		<ul>
			<li class="current">
			<s:url id="first" value="findByConditionList.action">
				<s:param name="currPageNo" value="1"></s:param>
			</s:url>
			<s:a href="%{first}">首页</s:a>
			<!-- <a href="/HouseRent/index.action?number=1">首页</a> --></li>
			<li>
			<s:url id="pre" value="findByConditionList.action">
				<s:param name="currPageNo" value="currPageNo - 1 < 1 ? 1:currPageNo - 1"></s:param>
			</s:url>
			<s:a href="%{pre}">上一页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="prev"/>'>上一页</a> --%></li>
			<li>
			<s:url id="nex" value="findByConditionList.action">
				<s:param name="currPageNo" value="currPageNo + 1 > page.totalPage ? page.totalPage:currPageNo + 1"></s:param>
			</s:url>
			<s:a href="%{nex}">下一页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="next"/>'>下一页</a> --%></li>
			<li>
			<s:url id="last" value="findByConditionList.action">
				<s:param name="currPageNo" value="page.totalPage"></s:param>
			</s:url>
			<s:a href="%{last}">末页</s:a>
			<%-- <a href='/HouseRent/index.action?number=<s:property value="total"/>'>末页</a> --%></li>
		</ul>
		<span class="total"><s:property value="currPageNo"/>/<s:property value="page.totalPage"/>页</span>
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