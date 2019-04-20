<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">

<head>
    <title>添加订单</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">

    <script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-1.12.4.js'></script>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        function doSave() {
            //document.forms[0].elements["op"].value = "doAdd";
            document.forms[0].action = "addOrders.action";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div class="main"><img src="images/esale_logo.gif" alt=""></img></div>
<div class="main" style="text-align:left;">
    <b>您当前的位置：</b><a href="#">销售管理</a> &gt; 添加订单
    <hr color="#A37B74" size="1px"/>
</div>
<div class="main">
    <form action="order" method="post">
        <input type="hidden" name="op" value="doAdd"/>
        <input type="hidden" name="item.cusCustomer.cusId" value="0"/>
        <input type="hidden" name="item.odrStatus" value="新创建"/>
        <table class="input_table" border="0" cellPadding="3" cellSpacing="0">
            <tr>
                <td class="input_title">订单编号</td>
                <td class="input_content"><input type="text" name="item.odrId" readonly="true"/></td>
                <td class="input_title">下单日期</td>
                <td class="input_content"><input type="text" name="item.odrOrderDate" onfocus="WdatePicker({lang:'en'})"
                                                 class="Wdate"/>
                </td>
            </tr>
            <tr>
                <td class="input_title">客户名称</td>
                <td class="input_content"><input type="text" name="item.odrCustomerName"/>&nbsp;[<span
                        style="cursor:hand;" onclick="ShowCusMag('dvCus');">选择</span>]
                </td>
                <td class="input_title">送货时间</td>
                <td class="input_content"><input type="text" name="item.odrDeliverDate"
                                                 onfocus="WdatePicker({lang:'en'})" class="Wdate"/></td>
            </tr>
            <tr>
                <td class="input_title">送货地址</td>
                <td class="input_content" colspan="3"><input type="text" name="item.odrDeliverAddr" size="50"/></td>
            </tr>
        </table>
    </form>
    <button onclick="javascript:doSave();">保 存</button>
    <button onclick="javascript:doSubmit();" disabled="disabled">提 交</button>
</div>
<div class="main" style="text-align:right;">
    <hr color="#A37B74" size="1px"/>
    &copy; 2016 北京阿博泰克北大青鸟信息技术有限公司
</div>


<script>
    function CloseDiv(id) {
        var oDiv = document.getElementById(id);
        if (oDiv) {
            oDiv.style.display = "none";
        }
    }

    function ShowDiv(id) {
        var oDiv = document.getElementById(id);
        if (oDiv) {
            oDiv.style.display = "block";
        }
    }

    var reply0 = function (data) {
        if (data != null && typeof data == 'object') {
            if (data.length) {
                var outHtml = "<table>";
                for (var i = 0; i < data.length; ++i) {
                    var cus = data[i];
                    outHtml += "<tr>";
                    outHtml += "<td width='180'>" + cus.cusName + "</td>";
                    outHtml += "<td>[<span style=\"cursor:hand;\" onclick=\"SelectCus('" + cus.cusId + "','" +
                        cus.cusName + "','" + cus.cusAddr + "');\" >选择</span>]</td>";
                    outHtml += "</tr>";
                }
                outHtml += "</table>";
                var oTable = document.getElementById("tCusList");
                oTable.outerHTML = outHtml;
            }
        }
    }

    function ShowCusMag() {
        $.getJSON("searchCustomer.action", function (data) {
            if (data != null) {
                var outHtml = "<table>";
                $.each(data, function (i, d) {
                    outHtml += "<tr>";
                    outHtml += "<td width='180'>" + d.cusName + "</td>";
                    outHtml += "<td>[<span style=\"cursor:hand;\" onclick=\"SelectCus('" + d.cusId + "','" +
                        d.cusName + "','" + d.cusAddr + "');\" >选择</span>]</td>";
                    outHtml += "</tr>";
                });
                outHtml += "</table>";
                var oTable = document.getElementById("tCusList");
                if(oTable!=null){
                    oTable.outerHTML = outHtml;
                }
            }
        });
        ShowDiv('dvCus');
    }

    function SelectCus(cusId, cusName, cusAddr) {

        var oCusIdInput = document.forms[0].elements["item.cusCustomer.cusId"];
        oCusIdInput.value = cusId;
        var oCusNameInput = document.forms[0].elements["item.odrCustomerName"];
        oCusNameInput.value = cusName;
        var oCusAddrInput = document.forms[0].elements["item.odrDeliverAddr"];
        oCusAddrInput.value = cusAddr;
        CloseDiv('dvCus');
    }
</script>
<div id="dvCus" width="250" style='display:none;z-index:999;left:126px;width:250px;position:absolute;top:160px;'>
    <table cellSpacing=0 cellPadding=0 width="250" border=0 style="Z-INDEX:1000;LEFT:0px;POSITION:absolute;TOP:0px">
        <tr>
            <td background="images/layer08.gif" width="150" height="30" valign="middle"><img src="images/none.gif"
                                                                                             alt="" width="35"
                                                                                             height="1" border="0"><font
                    color="white">请选择客户</font>&nbsp;&nbsp;<br>
                <img src="images/none.gif" alt="" width="1" height="2" border="0"></TD>
            <td background="images/layer09.gif" width="100" height="30" align="right" valign="middle">
                &nbsp;&nbsp;<a onclick="CloseDiv('dvCus')" style="cursor:pointer"><font color="white">[关闭]</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
            </TD>
        </tr>
        <tr>
            <td background="images/layer10.gif" colspan="2" style="padding:15px 5px;">
                <table id="tCusList">
                    <tr>
                        <td>正在加载......</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="2"><img src="images/layer11.gif" width="250" height="16" border="0"></TD>
        </tr>
    </table>
</div>

</body>
</html>
