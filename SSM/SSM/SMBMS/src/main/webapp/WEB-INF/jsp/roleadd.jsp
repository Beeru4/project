<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>角色管理页面 >> 角色添加页面</span>
    </div>
    <div class="providerAdd">
        <%--此页面 提交地址和name更改了 /jsp/provider.do--%>
        <form id="providerForm" name="providerForm" method="post"
              action="${pageContext.request.contextPath }/sys/role/doAddRole">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label for="proCode">角色编码：</label>
                <input type="text" name="roleCode" id="proCode" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="proName">角色名称：</label>
                <input type="text" name="roleName" id="proName" value="">
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/roleadd.js"></script>
