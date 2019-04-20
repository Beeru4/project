<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript">
			$(function(){				
			//表单提交校验
		
			//$("#myTable tr").eq(0).hide();	
			$("form[name='claimForm']").submit(function(){
				//判断是否加入了问题 
				if($("#rowNumber").val()<1){
					//$.messager.defaults={ok:"确定"};$.messager.alert("提示信息",$("#rowNumber").val());
					$("#notice").text("* 添加报销单的明细，至少一条 ！");
					return false;
				}	
				$("#notice").text("*");
				for(var s=0;s<$("#rowNumber").val();s++){
					$("#account"+s).next(".notice").text("*");
					$("#des"+s).next(".notice").text("*");
					if(isEmpty($("#account"+s).val())){
						$("#account"+s).next(".notice").text("* 金额不能为空  ！");
						return false;
					}		
					if(isEmpty($("#des"+s).val())){
						$("#des"+s).next(".notice").text("* 金额不能为空  ！");
						return false;
					}		
								
				}
				$(".buttons").hide();
				return true;
			});	
			$("#AddRow").click(function(){		
				var tr=$("#myTable tr").eq(0).clone();
				++i;
				var j=i-1;
				var item = $("#item").val();
				var account = $("#account").val();
				totalAccount=parseFloat(totalAccount)+parseFloat(account);
				var desc = $("#des").val();
				tr.find("td").get(0).innerHTML="<input  name=detailList["+j+"].item id=item"+j+" type=hidden value="+item+" />"+item;
				tr.find("td").get(1).innerHTML="<input  name=detailList["+j+"].account id=account"+j+"  type=hidden value="+account+" />"+account;
				tr.find("td").get(2).innerHTML="<input  name=detailList["+j+"].des  id=des"+j+" type=hidden value="+desc+" />"+desc;
				tr.find("td").get(3).innerHTML="<input type=button name=DelRow"+j+" id=DelRow"+j+" onclick=delRow("+j+") value="+'删除'+" />";
				tr.find("td").get(3).innerHTML="<img src=${images}/delete.gif width=16 height=16 id=DelRow"+j+" onclick=delRow("+j+") />";
				tr.show();
				tr.appendTo("#myTable");
				//传递一共添加多少问题 
				rowNumber=i;
				$("#account").attr("value","");
				$("#des").attr("value","");
				$("#totalAccount").attr("value",totalAccount);
		
			});	
			
		});
		var i=0;
		var rowNumber=0;
		var totalAccount = 0;
		function delRow(id){	
			var account = $("#account"+id).val();
			$("#myTable tr").eq(id+1).remove();
			//var rowNumber=$("#rowNumber").val();
				for(var s=id+1;s<rowNumber;s++){
				$("#item"+s).attr("name","detailList["+(s-1)+"].item");
				$("#item"+s).attr("id","item"+(s-1));
				$("#account"+s).attr("name","detailList["+(s-1)+"].account");
				$("#account"+s).attr("id","account"+(s-1));
				$("#des"+s).attr("name","detailList["+(s-1)+"].des");
				$("#des"+s).attr("id","des"+(s-1));
				var js="delRow("+(s-1)+");";
				var newclick=eval("(false||function (){"+js+"});");
				$("#DelRow"+s).unbind('click').removeAttr('onclick').click(newclick);
				$("#DelRow"+s).attr("id","DelRow"+(s-1));					
				}
			$("#rowNumber").attr("value",rowNumber-1);
			--i;
			totalAccount=parseFloat(totalAccount)-parseFloat(account);
			$("#totalAccount").attr("value",totalAccount);
		}
		function submitClaimVoucher(action){
	   		if(!confirm("确定"+action+"报销单吗")) return;
	   		if (action == '保存'){
	   			document.claimForm.status.value = "新创建";
	   		}else{
	   			document.claimForm.status.value = "已提交";
	   		}
	   		
	   		document.claimForm.submit();
		   		
		 }
		</script>
		
		</head>
	<body>
	<div class="action  divaction">
		<div class="t">报销单添加</div>
		<div class="pages">
			<s:form action="addVoucher.action" name="claimForm" method="POST">
			
			<input type="hidden" id="rowNumber" name="rowNumber" value="<s:property value="rowNumber"/>"/>
				<table width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr>
						<td>*填报人：</td>
						<td><s:property value="#session.emp.name"/></td>
						<td>*填报时间：</td>
						<td ><input type="text" name="voucher.createTime" id="date_info" readonly="readonly" /> </td>
					</tr>
					<tr>
						<td>*总金额：￥</td>
						<td><input type="text" id="totalAccount" name="voucher.totalAccount" value="" readonly="readonly" /></td>
						<td>*状态：</td>
						<td><input type="text" id="status" name="voucher.status" value="新创建"
								readonly="readonly"  /></td>
					</tr>
					<tr>
						<td colspan="4"><span class="notice" id="noctice">*</span></td>
					</tr>
				</table>
				<table id="myTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr>
						<td width="30%">项目类别</td>
						<td width="30%">项目金额</td>
						<td width="30%">费用说明</td>
						<td width="10%">操作</td>
					</tr>
				</table>
				<table id="detailTable" width="90%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<tr>
						<td width="30%">
							<select name="voucher.item" id="item">
								<option value="城际交通费">城际交通费</option>
								<option value="市内交通费">市内交通费</option>
								<option value="通讯费">通讯费</option>
								<option value="礼品费">礼品费</option>
								<option value="办公费">办公费</option>
								<option value="交际餐费">交际餐费</option>
								<option value="餐补">餐补</option>
								<option value="住宿费">住宿费</option>
							</select>
						</td>
						<td width="30%"><input type="text" name="voucher.account" id="account" /><span class=notice>*</span></td>
						<td width="30%"><input type="text" name="voucher.des" id="des" /><span class=notice>*</span></td>
						<td width="10%"><img src="/images/add.gif" width="16" height="16" id="AddRow"/></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>*事由：</td>
						<td colspan="3"><textarea rows="5" cols="66" name="voucher.event"
										id="event"></textarea>
						</td>
					</tr>
					<tr align="center" colspan="4">
						<td>
							&nbsp; 
						</td>
						<td >
						<input type="button" id="1" name="1" value="保存" onclick="submitClaimVoucher('保存')" class="submit_01"/>
							<input type="button" id="2" name="2" value="提交" class="submit_01"
								onclick="submitClaimVoucher('提交')" />
						</td>
					</tr>
				</table>
				</s:form>
			</div>
		</div>
	</body>
	<script>

        Date.prototype.Format = function (fmt) {
            var o = {
                "M+": this.getMonth() + 1, // 月份
                "d+": this.getDate(), // 日
                "h+": this.getHours(), // 小时
                "m+": this.getMinutes(), // 分
                "s+": this.getSeconds(), // 秒
                "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
                "S": this.getMilliseconds() // 毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }


        $(document).ready(function () {
            $('#date_info').val(new Date().Format("yyyy-MM-dd hh:mm:ss"));
        })
	</script>
</html>
