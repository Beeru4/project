<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
<head>
    <title>添加订单</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <script type="text/javascript">
        function doSave() {
            //document.forms[0].elements["op"].value = "doAdd";
            document.forms[0].action = "order!doAdd.action";
            document.forms[0].submit();
        }

        function doAddDetail() {
            if ($('[name="line.odlProductCount"]').val() == 0) {
                alert("请选择个数!");
            } else {
                //document.forms[0].elements["op"].value = "doAddDetail";
                // document.forms[0].action = "doAddCustomer.action";
                /*  document.forms[0].submit();*/

                var index = $("[value='" + $('#line_odlProductName').val() + "']").val();//保存数据
                //拼接传输数据
                var json = {
                    "line.odlProductName": $("[value='" + $('#line_odlProductName').val() + "']").text()
                    , "line.odlProductCount": $('[name="line.odlProductCount"]').val()
                    , "line.odlProductPrice": $('[name="total"]').val()
                    , "item.odrId": $('[ name="line.saleOrder.odrId"]').val()
                };

                //使用ajax保存数据
                $.getJSON("doAddOrders.action", json, function (data) {
                    //判断是否添加成功

                    //请求回来的数据循环拼接页面
                    var stg = '<tr> ';
                    stg += '<td class="data_title" style="width:200px;">产品名称</td> ';
                    stg += '<td class="data_title" style="width:100px;">单价</td> ';
                    stg += '<td class="data_title" style="width:100px;">数量</td> ';
                    stg += '<td class="data_title" style="width:100px;">总价</td> ';
                    stg += '<td class="data_title">操作</td> ';
                    stg += '</tr> ';

                    //遍历数据
                    $.each(data.saleOrderLines, function (i, o) {
                        //找到数据
                        stg += '<tr> ';
                        stg += '<td class="data_cell">' + o.odlProductName + '</td> ';
                        stg += '<td class="data_cell" style="text-align:right;">' + o.odlProductPrice + '</td> ';
                        stg += '<td class="data_cell" style="text-align:right;">' + o.odlProductCount + '</td> ';
                        stg += '<td class="data_cell" style="text-align:right;">' + o.odlProductPrice * o.odlProductCount + '</td> ';
                        stg += '<td class="data_cell"> ';
                        stg += '<button disabled="disabled">删除</button> ';
                        stg += '</td>';
                        stg += '</tr>';
                    });

                    $("#clear").siblings().remove();
                    $("#clear").before(stg);



                    if (data.code = 1001) {
                        //清空
                        $('[value="0"]').attr("selected", true);
                        $('[name="line.odlProductCount"]').val(0);
                        $('[name="total"]').val(0);
                        $('[name="line.odlProductPrice"]').val(0);
                        $('[value='+index+']').attr("selected", false);
                    } else {
                        alert("添加失败!");
                    }


                });
            }
        }

        function setProdPrice(oSelect) {
            var text = oSelect.options[oSelect.selectedIndex].text;


            if (text == "请选择...") {
                var oPrice = document.forms[0].elements["line.odlProductPrice"].value = "0";
                var count = document.forms[0].elements["line.odlProductCount"].value = 0;
                $("#save").attr("disabled", "disabled");
            } else {
                var arr = text.split('-');
                var pri = arr[1];
                var oPrice = document.forms[0].elements["line.odlProductPrice"];
                oPrice.value = pri;
                $("#save").removeAttr("disabled", "disabled");
            }
            setTotal();
        }

        function setTotal() {
            var count = document.forms[0].elements["line.odlProductCount"].value;
            var price = document.forms[0].elements["line.odlProductPrice"].value;
            var oTotal = document.forms[0].elements["total"];
            oTotal.value = price * count;
        }
    </script>
</head>
<body>
<div class="main"><img src="/images/esale_logo.gif" alt=""></img></div>
<div class="main" style="text-align:left;">
    <b>您当前的位置：</b><a href="#">销售管理</a> &gt; 添加订单
    <hr color="#A37B74" size="1px"/>
</div>
<div class="main">
    <form action="" onsubmit="return false;" method="post">
        <input type="hidden" name="op" value="doAdd"/>
        <table class="input_table" border="0" cellPadding="3" cellSpacing="0">
            <tr>
                <td class="input_title">订单编号</td>
                <td class="input_content"><s:property value="item.odrId"/></td>
                <td class="input_title">下单日期</td>
                <td class="input_content"><s:date name="item.odrOrderDate" format="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td class="input_title">客户名称</td>
                <td class="input_content"><s:property value="item.odrCustomerName"/></td>
                <td class="input_title">送货时间</td>
                <td class="input_content"><s:date name="item.odrDeliverDate" format="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td class="input_title">送货地址</td>
                <td class="input_content" colspan="3"><s:property value="item.odrDeliverAddr"/></td>
            </tr>
        </table>
        <table class="data_table" border="0" cellPadding="3" cellSpacing="0">
            <tr>
                <td class="data_title" style="width:200px;">产品名称</td>
                <td class="data_title" style="width:100px;">单价</td>
                <td class="data_title" style="width:100px;">数量</td>
                <td class="data_title" style="width:100px;">总价</td>
                <td class="data_title">操作</td>
            </tr>
            <s:iterator value="item.saleOrderLines" id="pl">
                <tr>
                    <td class="data_cell">${odlProductName }</td>
                    <td class="data_cell" style="text-align:right;">${odlProductPrice }</td>
                    <td class="data_cell" style="text-align:right;">${odlProductCount }</td>
                    <td class="data_cell" style="text-align:right;">${odlProductPrice * odlProductCount }</td>
                    <td class="data_cell">
                        <button disabled="disabled">删除</button>
                    </td>
                </tr>
            </s:iterator>
            <tr id="clear">
                <td class="data_cell">
                    <input type="hidden" name="line.saleOrder.odrId" value="${item.odrId }"/>
                    <s:select name="line.odlProductName"
                              onchange="javascript:setProdPrice(this);"
                              list="prodList"
                              listValue="prodName"
                              listKey="prodId"
                              headerKey="0"
                              headerValue="请选择..."
                              theme="simple">
                    </s:select>
                </td>
                <td class="data_cell"><input type="text" name="line.odlProductPrice" readonly="true" value="0"
                                             size="15"/></td>
                <td class="data_cell"><input type="text" name="line.odlProductCount" value="0"
                                             onblur="setTotal();"
                                             size="15"/></td>
                <td class="data_cell"><input type="text" name="total" readonly="readonly" value="0" size="15"/></td>
                <td class="data_cell">
                    <button onclick="javascript:doAddDetail();" id="save">保存订单行</button>
                </td>
            </tr>
        </table>

    </form>
    <button onclick="javascript:doSave();" disabled="disabled">保 存</button>
    <button onclick="javascript:doSubmit();" disabled="disabled">提 交</button>
</div>
<div class="main" style="text-align:right;">
    <hr color="#A37B74" size="1px"/>
    &copy; 2016 北京阿博泰克北大青鸟信息技术有限公司
</div>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $("#save").attr("disabled", "disabled");
</script>
</body>
</html>
