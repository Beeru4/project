<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="control.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<%--<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />--%>
    <style>
        *{ margin:0; padding:0;}
        body{ font:12px 宋体;}
        img{ border:0;}
        table{ border-collapse:collapse;}
        ul{ list-style:none;}
        .notice{ padding:0px 5px; color:#ff0000;} /*错误提示*/

        a{ color:#000; text-decoration: none;}
        a:hover{ color:#f30;}

        .red, .red a{ color:#f00;}
        .purple, .purple a{ color:#5D117D;}

        .global-width{ width:971px; margin:0 auto;}

        .top{ width:100%; height:88px; background:url(/images/Top_bg.gif) repeat-x;}
        .top .logo{ margin:17px 0 0 0;}

        .status{ width:100%; height:36px; background:url(/images/Top_bg.gif) repeat-x 0 bottom; line-height:36px;}
        .usertype{ color:#2357E7; margin-right:30px;}

        .main{ background:#4E93BB; height:100%; overflow:hidden; padding:14px 0;}
        /*菜单区域*/
        .nav{ float:left; width:191px; padding-bottom:69px; background:url(/images/left_bg.gif) no-repeat -382px bottom;}
        .nav .t{ height:51px; background:url(/images/left_bg.gif) no-repeat;}
        /*菜单 默认状态*/
        .nav dl{ background:url(/images/left_bg.gif) -191px 0 repeat-y; line-height:22px; padding-left:20px;}
        .nav dl dt{ background:url(/images/ico.gif) no-repeat 0 -23px; padding-left:32px;}
        .nav dl dd{ background:url(/images/ico.gif) no-repeat 18px -51px; padding-left:36px; display:none;}
        /*菜单 展开状态*/
        .nav dl.open dt{ background-position:0 0;}
        .nav dl.open dd{ display:block;}

        /*操作区域*/
        .action{ float:right; width:759px; padding-bottom:69px; background:url(/images/right.gif) no-repeat 0 bottom;}
        .divaction{ background:none;}
        .action .t{ height:41px; background:url(/images/right_bg.gif) no-repeat; font:14px 宋体; padding:10px 0 0 30px;}
        .action .pages{ border:#A8C8DA solid; width:727px; background:#fff; border-width:0 1px; padding-left:30px;}

        .copyright{ text-align:center; font:12px Arial; margin:20px 0; color:#000;}

        /*右侧文档通用样式*/
        .addform-base caption{ font:600 14px/40px 宋体; text-align:left;}
        .addform-base td{ padding:5px 0 5px;}

        .addform-item thead td{ font:600 14px/30px 宋体;}
        .addform-item td{ padding:5px 0;}

        .addform-item td.submit{ text-align:center; padding:12px 0;}
        .addform-item td.submit input{ margin:0 10px;}

        .event label{ float:left; font:600 14px/20px 宋体; margin:16px 0 0 14px;}
        .event textarea{ width:456px; height:52px; border:1px #797979 solid; margin-top:16px;}

        .input_01{ width:127px; height:20px; border:1px #797979 solid;}
        .submit_01{ width:101px; height:24px; border:0; background:url(/images/submit.gif) no-repeat; text-align:center; font:14px/24px 宋体;}

        .list td{ font:12px/30px 宋体;}

        /*new css*/
        .marg{margin:10px 0 0}
        .forms{margin:0 0 10px;}
        .nwselect{ height:18px;border:1px solid #7eabab}
        .nwinput{ width:120px; height:18px; border:1px solid #7eabab}
        .items{border:1px solid #D0E3EF;border-collapse:collapse; background:#fff; text-align:center}
        .items .even{ background:#EBF6FA;}
        .items td{border:1px solid #D0E3EF;}
        .submits{background:url(/images/submits.jpg) no-repeat; width:71px; height:25px; text-align:center; cursor:pointer; border:none; color:#3B72A0}
        /*leave*/
        .leave td{height:25px;}
        .leave .width1{width:80px; text-align:right}
        .leave .width2{width:220px;}
        .leave input{ width:142px;}
        .leave .nwselect{height:20px; width:144px}
        .textarea{width:440px; height:80px; margin:5px 0 0}
        .prompt{padding:20px 0 0; line-height:23px;}
        .prompt dt{color:#F00; font-weight:bold}
        .prompt dd{ text-indent:2em}
        .prompt dd span{color:#F00}
        .activity{margin:0 0 10px}
        .activity h3{ border:1px solid #C8E5F5; background:#EBF6FA; line-height:30px; font-weight:bold; text-indent:20px; margin:30px 0 0}
    </style>
	</head>
<body>
<form id="myForm" name="myForm" method="post" >
    <div class="action  divaction">
    	<div class="t">查看报销单</div>
   		<div class="pages">
        	<!--增加报销单 区域 开始-->
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <caption>基本信息</caption>
                  <tr>
                  	<td >编&nbsp;&nbsp;号：<s:property value="voucher.id"/></td>
                    <td>填&nbsp;写&nbsp;人：<s:property value="voucher.createSn.name"/></td>
                    <td>部&nbsp;&nbsp;门：<s:property value="voucher.createSn.department.name"/></td>
                    <td>职&nbsp;&nbsp;&nbsp;&nbsp;位：<s:property value="voucher.createSn.position.nameCn"/></td>
                  </tr>
                  <tr>
                    <td>总金额：<s:property value="voucher.totalAccount"/></td>
                    <td>填报时间：<s:date name="voucher.createTime" format="yyyy-MM-dd hh:mm:ss"/></td>
                    <td>状态：<s:property value="voucher.status"/></td>
                    <td>待处理人：<s:property value="voucher.nextDealSn.name"/></td>
                  </tr>
                  <tr>
                  	<td colspan="4"><p>-------------------------------------------------------------------------------</p></td>
                  </tr>
                </table>
          <p>&nbsp;</p>
                <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
                  <tr>
                    <td>项目类别</td>
                    <td>项目金额</td>
                    <td>费用说明</td>
                  </tr>
                <s:iterator value="voucher.voucherDetalls" id="claimDetail" begin="0" status="s">
				<tr>
					<td><s:property value="#claimDetail.item"/></td>
					<td>￥<s:property value="#claimDetail.account"/></td>
					<td><s:property value="#claimDetail.des"/></td>
				</tr>
				</s:iterator>
      </table>
      <p>&nbsp;</p>
      <p>-------------------------------------------------------------------------------</p>
      
      <table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
      	<s:iterator value="voucher.checkDetall" id="checkResult" begin="0" status="s">
         <tr>
           <td width="27%"><s:property value="#checkResult.checkerSn.name" />(<s:property value="#checkResult.checkerSn.position.nameCn" />)</td>
           <td width="20%"><s:date name="#checkResult.checkTime" format="yyyy-MM-dd hh:mm:ss"/></td>
           <td width="38%">审核：<span class="red"><strong><s:property value="#checkResult.result" /></strong></span></td>
         </tr>
         <tr>
             <td>审核意见：<strong><s:property value="#checkResult.comm" /></strong></td>
           <td>&nbsp;</td>
           <td>&nbsp;</td>
         </tr>
         <tr>
         	<td colspan="3">
         		<p>-------------------------------------------------------------------------------</p>
           	</td>
         </tr>
         </s:iterator>
         
    </table>
    <p>&nbsp;</p>
   
    <p>&nbsp;</p>
    <p><input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/></p>       
        <!--增加报销单 区域 结束-->
        </div>
    </div>
</form>
</body>