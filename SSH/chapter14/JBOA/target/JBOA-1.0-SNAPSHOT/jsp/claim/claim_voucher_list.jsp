<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ include file="control.jsp"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function(){
			 //日期选择控件
		 	$("#startDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',isShowClear:true, readOnly:true });
			});
			$("#endDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',isShowClear:true, readOnly:true });
			});
		});
   	function delVoucher(id){
   		if(!confirm('确定删除报单吗')) return;

   		document.claimVoucherForm.action = "claimVoucher_deleteClaimVoucherById.action?claimVoucher.id="+id;
   		document.claimVoucherForm.submit();

   	}

</script>
<div class="action  divaction">
	<div class="t">报销单列表</div>
	<div class="pages">
		<div class="forms">
			 <s:form action="listVoucher.action" name="queryForm">
	       		<label>报销单状态</label>
	  			<%--<s:select name="claimVoucher.status" list="statusMap"
	  			listKey="key" listValue="value" headerKey="" headerValue="全部" theme="simple"></s:select>--%>
				 <select name="voucher.status" id="">
                     <option value="全部" <s:if test="voucher.status == '全部'">selected="selected"</s:if>>全部</option>
					 <option value="已提交" <s:if test="voucher.status == '已提交'">selected="selected"</s:if>>已提交</option>
					 <option value="待审批" <s:if test="voucher.status == '待审批'">selected="selected"</s:if>>待审批</option>
					 <option value="已打回" <s:if test="voucher.status == '已打回'">selected="selected"</s:if>>已打回</option>
					 <option value="已审批" <s:if test="voucher.status == '已审批'">selected="selected"</s:if>>已审批</option>
					 <option value="已付款" <s:if test="voucher.status == '已付款'">selected="selected"</s:if>>已付款</option>
					 <option value="已终止" <s:if test="voucher.status == '已终止'">selected="selected"</s:if>>已终止</option>
				 </select>
		       <label for="time">开始时间</label>
                 <input  type="text" name="voucher.createTime" id="startDate" class="nwinput" value="<s:date format="yyyy-MM-dd" name="voucher.createTime"/>"/>

		       <label for="end-time">结束时间</label>
                 <input  type="text" name="voucher.modifyTime" id="endDate" class="nwinput" value="<s:date format="yyyy-MM-dd" name="voucher.modifyTime"/>"/>
		      <%-- <input type="hidden" name="pageNo" value="1"/>
		 	   <input type="hidden" name="pageSize" value="5"/>--%>
                 <input type="submit" value="查询" class="submit_01">
	       </s:form>
	     </div>
	<!--增加报销单 区域 开始-->
	<s:form action="claimVoucher_searchClaimVoucher.action" name="claimVoucherForm">
		<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items" >
	      <tr class="even">
	        <td>编号</td>
	        <td>填报日期</td>
	        <td>填报人</td>
	        <td>总金额</td>
	        <td>状态</td>
	        <td>待处理人</td>
	        <td>操作</td>
	      </tr>
	      <s:iterator value="items" id="claimVoucher" begin="0" status="s"><%--  <s:iterator value="employee.items" id="claimVoucher" begin="0" status="s">--%>
	      <tr>
	        <td><a href="claimVoucher_getClaimVoucherById.action?claimVoucher.id=<s:property value="#claimVoucher.id"/>"><s:property value="#claimVoucher.id"/></a></td>
	        <td><s:date name="#claimVoucher.createTime" format="yyyy-MM-dd"/></td>
	        <td><s:property value="#claimVoucher.createSn.name"/></td>
	        <td><s:property value="#claimVoucher.totalAccount"/></td>
	        <td><s:property value="#claimVoucher.status"/></td>
	        <td><s:property value="#claimVoucher.nextDealSn.name"/></td>
	        <td>
	        	<s:if test="#claimVoucher.status == '新创建' || #claimVoucher.status == '已打回'">
	        		<a href="forwordVoucher.action?id=<s:property value="#claimVoucher.id"/>">
			        	<img src="${images}/edit.gif" width="16" height="16" />
			        </a>
			        <a onClick="delVoucher(<s:property value="#claimVoucher.id"/>)" href="#">
			        	<img src="${images}/delete.gif" width="16" height="16" />
			        </a>
		        </s:if>
		        <img src="${images}/save.gif" width="16" height="16" />
		        <a href="getVoucher.action?id=<s:property value="#claimVoucher.id"/>">
		        	<img src="${images}/search.gif" width="16" height="15" />
		        </a>
		        <s:if test="#claimVoucher.nextDealSn.name == #session.emp.name">
		        	<s:if test="#claimVoucher.status == '已提交' || #claimVoucher.status == '待审批' || #claimVoucher.status == '已审批'">
				        <a href="getCheckVoucher.action?id=<s:property value="#claimVoucher.id"/>">
				         <img src="${images}/sub.gif" width="16" height="16" />
				        </a>
			        </s:if>
		        </s:if>
	        </td>
	      </tr>
	      </s:iterator>
	      <tr>
	        <td colspan="6" align="center">
		     <%-- 	<c:import url="rollPage.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="document.forms[0]"/>
				<c:param name="totalRecordCount" value="${pageSupport.totalCount}"/>
				<c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
				<c:param name="currentPageNo" value="${pageSupport.currPageNo}"/>
  			</c:import>

--%>

<s:if test="currPageNo > 1">
	<s:url id="first" value="listVoucher.action">
		<s:param name="currPageNo" value="1"></s:param>
	</s:url>
	<s:a href="%{first}">首页</s:a>

	<s:url id="pre" value="listVoucher.action">
		<s:param name="currPageNo" value="currPageNo - 1 < 1 ? 1:currPageNo - 1"></s:param>
	</s:url>
	<s:a href="%{pre}">上一页</s:a>
</s:if>
<s:else>
	<s:url id="nex" value="listVoucher.action">
		<s:param name="currPageNo" value="currPageNo + 1 > totalPage ? totalPage:currPageNo + 1"></s:param>
	</s:url>
	<s:a href="%{nex}">下一页</s:a>

	<s:url id="last" value="listVoucher.action">
		<s:param name="currPageNo" value="totalPage"></s:param>
	</s:url>
	<s:a href="%{last}">最后一页</s:a>
</s:else>


                <span class="total">第<s:property value="currPageNo"/>页/共<s:property value="totalPage"/>页&nbsp;&nbsp;&nbsp;共<s:property value="totalRow"/>条记录</span>









  		  	</td>
  		  </tr>
	    </table>
	   </s:form>
	          <!--增加报销单 区域 结束-->
       </div>
      </div>
